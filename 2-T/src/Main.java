package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoardState board = new BoardState(13);
            GoWindow window = new GoWindow(board);
            window.setVisible(true);
        });
    }
}
