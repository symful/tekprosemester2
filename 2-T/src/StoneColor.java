package src;

public enum StoneColor {
    BLACK, WHITE, NONE;

    public StoneColor opponent() {
        if (this == BLACK) return WHITE;
        if (this == WHITE) return BLACK;
        return NONE;
    }
}
