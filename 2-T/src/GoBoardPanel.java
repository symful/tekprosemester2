package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class GoBoardPanel extends JPanel {
    private final BoardState board;
    private final GoWindow window;

    public GoBoardPanel(BoardState board, GoWindow window) {
        this.board = board;
        this.window = window;
        setBackground(new Color(235, 195, 130));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int size = board.getSize();
                int margin = 35;
                int cellSize = (getWidth() - 2 * margin) / (size - 1);

                int col = (e.getX() - margin + cellSize / 2) / cellSize;
                int row = (e.getY() - margin + cellSize / 2) / cellSize;

                if (row >= 0 && row < size && col >= 0 && col < size) {
                    StoneColor p = board.getNextToMove();
                    if (board.placeStone(row, col, p)) {
                        window.addMove(p + " (" + (row + 1) + "," + (char)('A' + col) + ")");
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = board.getSize();
        int margin = 35;
        int cellSize = (getWidth() - 2 * margin) / (size - 1);

        g2.setColor(new Color(60, 40, 20));
        g2.setStroke(new BasicStroke(1.2f));
        for (int i = 0; i < size; i++) {
            g2.drawLine(margin, margin + i * cellSize, margin + (size - 1) * cellSize, margin + i * cellSize);
            g2.drawLine(margin + i * cellSize, margin, margin + i * cellSize, margin + (size - 1) * cellSize);
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                StonePosition pos = new StonePosition(r, c);
                var colorOpt = board.getStone(pos);
                if (colorOpt.isPresent()) {
                    StoneColor color = colorOpt.get();
                    int x = margin + c * cellSize - cellSize / 2 + cellSize / 8;
                    int y = margin + r * cellSize - cellSize / 2 + cellSize / 8;
                    int d = (int)(cellSize * 0.85);

                    if (color == StoneColor.BLACK) {
                        RadialGradientPaint p = new RadialGradientPaint(
                            new Point2D.Float(x + d/3f, y + d/3f), d,
                            new float[]{0f, 1f}, new Color[]{new Color(70, 70, 70), Color.BLACK}
                        );
                        g2.setPaint(p);
                    } else {
                        RadialGradientPaint p = new RadialGradientPaint(
                            new Point2D.Float(x + d/3f, y + d/3f), d,
                            new float[]{0f, 1f}, new Color[]{Color.WHITE, new Color(200, 200, 200)}
                        );
                        g2.setPaint(p);
                    }
                    g2.fillOval(x, y, d, d);
                    g2.setColor(new Color(0, 0, 0, 50));
                    g2.drawOval(x, y, d, d);
                }
            }
        }
    }
}
