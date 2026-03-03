package src;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BoardState {
    private final int size;
    private final Map<StonePosition, StoneColor> stones = new ConcurrentHashMap<>();
    private final List<StonePosition> history = new ArrayList<>();
    private static final List<int[]> DIRS = List.of(
        new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}
    );

    private final Deque<Map<StonePosition, StoneColor>> snapshots = new ArrayDeque<>();
    private StoneColor nextToMove = StoneColor.BLACK;

    public BoardState(int size) {
        this.size = size;
    }

    public boolean placeStone(int r, int c, StoneColor color) {
        if (color != nextToMove) return false;
        StonePosition pos = new StonePosition(r, c);
        if (r < 0 || r >= size || c < 0 || c >= size || stones.containsKey(pos)) {
            return false;
        }

        Map<StonePosition, StoneColor> snapshot = new HashMap<>(stones);
        stones.put(pos, color);
        
        boolean captureMade = false;
        for (int[] d : DIRS) {
            StonePosition neighbor = new StonePosition(r + d[0], c + d[1]);
            Optional<StoneColor> neighborColor = getStone(neighbor);
            if (neighborColor.isPresent() && neighborColor.get() == color.opponent()) {
                if (getLiberties(neighbor).isEmpty()) {
                    captureGroup(neighbor);
                    captureMade = true;
                }
            }
        }

        if (!captureMade && getLiberties(pos).isEmpty()) {
            stones.clear();
            stones.putAll(snapshot);
            return false;
        }

        snapshots.push(snapshot);
        history.add(pos);
        nextToMove = nextToMove.opponent();
        return true;
    }

    public void undo() {
        if (!snapshots.isEmpty()) {
            stones.clear();
            stones.putAll(snapshots.pop());
            history.remove(history.size() - 1);
            nextToMove = nextToMove.opponent();
        }
    }

    public void reset() {
        stones.clear();
        snapshots.clear();
        history.clear();
        nextToMove = StoneColor.BLACK;
    }

    public Optional<StoneColor> getStone(StonePosition pos) {
        return Optional.ofNullable(stones.get(pos));
    }

    private Set<StonePosition> getGroup(StonePosition start) {
        StoneColor color = stones.get(start);
        Set<StonePosition> group = new HashSet<>();
        Queue<StonePosition> queue = new ArrayDeque<>();
        
        queue.add(start);
        group.add(start);

        while (!queue.isEmpty()) {
            StonePosition curr = queue.poll();
            for (int[] d : DIRS) {
                StonePosition next = new StonePosition(curr.row() + d[0], curr.col() + d[1]);
                if (stones.get(next) == color && !group.contains(next)) {
                    group.add(next);
                    queue.add(next);
                }
            }
        }
        return group;
    }

    private Set<StonePosition> getLiberties(StonePosition start) {
        StoneColor color = stones.get(start);
        if (color == null) return Collections.emptySet();
        Set<StonePosition> group = getGroup(start);
        Set<StonePosition> liberties = new HashSet<>();

        for (StonePosition pos : group) {
            for (int[] d : DIRS) {
                int nr = pos.row() + d[0];
                int nc = pos.col() + d[1];
                if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
                    StonePosition neighbor = new StonePosition(nr, nc);
                    if (!stones.containsKey(neighbor)) {
                        liberties.add(neighbor);
                    }
                }
            }
        }
        return liberties;
    }

    public StoneColor getNextToMove() {
        return nextToMove;
    }

    private void captureGroup(StonePosition start) {
        for (StonePosition pos : getGroup(start)) {
            stones.remove(pos);
        }
    }

    public int getSize() {
        return size;
    }

    public List<StonePosition> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
