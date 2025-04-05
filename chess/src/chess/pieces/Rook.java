package chess.pieces;

import chess.ChessBoard;

public class Rook extends Piece {
    public Rook(int row, int col, char color) {
        super(row, col, color, 5);
    }

    @Override
    public boolean isThreatening(Piece other) {
        if (other.getColor() == color) return false;
        if (other.getRow() == row || other.getCol() == col) {
            ChessBoard board = ChessBoard.getInstance();
            return board.isPathClear(this, other);
        }
        return false;
    }

}
