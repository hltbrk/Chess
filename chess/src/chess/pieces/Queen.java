package chess.pieces;

import chess.ChessBoard;

public class Queen extends Piece {
    public Queen(int row, int col, char color) {
        super(row, col, color, 9);
    }


    @Override
    public boolean isThreatening(Piece other) {
        if (!isOpponent(other)) return false;

        int dr = other.getRow() - this.getRow();
        int dc = other.getCol() - this.getCol();

        // Dikey, yatay veya çapraz ise
        if (dr == 0 || dc == 0 || Math.abs(dr) == Math.abs(dc)) {
            return board.isPathClear(this, other);
        }
        return false;
    }


}
