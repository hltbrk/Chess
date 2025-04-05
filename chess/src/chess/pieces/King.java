package chess.pieces;

public class King extends Piece {
    public King(int row, int col, char color) {
        super(row, col, color, 100);
    }

    @Override
    public boolean isThreatening(Piece other) {
        int dx = Math.abs(other.getRow() - row);
        int dy = Math.abs(other.getCol() - col);
        return other.getColor() != color && dx <= 1 && dy <= 1;
    }
}
