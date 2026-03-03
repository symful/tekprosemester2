package src;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class GoWindow extends JFrame {

    private final Vector<String> moveHistory = new Vector<>();
    private final JList<String> historyList = new JList<>(moveHistory);

    public GoWindow(BoardState board) {
        setTitle("Weiqi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GoBoardPanel boardPanel = new GoBoardPanel(board, this);
        boardPanel.setPreferredSize(new Dimension(700, 700));
        add(boardPanel, BorderLayout.CENTER);

        JPanel sidePanel = new JPanel(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(200, 700));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel controlPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JButton undoBtn = new JButton("Rewind (Undo)");
        JButton resetBtn = new JButton("Reset Board");

        undoBtn.addActionListener(e -> {
            board.undo();
            if (!moveHistory.isEmpty()) moveHistory.remove(
                moveHistory.size() - 1
            );
            historyList.setListData(moveHistory);
            boardPanel.repaint();
        });

        resetBtn.addActionListener(e -> {
            board.reset();
            moveHistory.clear();
            historyList.setListData(moveHistory);
            boardPanel.repaint();
        });

        controlPanel.add(undoBtn);
        controlPanel.add(resetBtn);
        sidePanel.add(controlPanel, BorderLayout.NORTH);

        historyList.setBackground(new Color(245, 245, 245));
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Move History"));
        sidePanel.add(scrollPane, BorderLayout.CENTER);

        add(sidePanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }

    public void addMove(String move) {
        moveHistory.add(move);
        historyList.setListData(moveHistory);
        historyList.ensureIndexIsVisible(moveHistory.size() - 1);
    }
}
