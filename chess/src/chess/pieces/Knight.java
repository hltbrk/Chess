package chess.pieces;

public class Knight extends Piece {
    public Knight(int row, int col, char color) {
        super(row, col, color, 3);
    }

    @Override
    public boolean isThreatening(Piece other) {
        int dx = Math.abs(other.getRow() - row);
        int dy = Math.abs(other.getCol() - col);
        return other.getColor() != color &&
                ((dx == 2 && dy == 1) || (dx == 1 && dy == 2));
    }
}
