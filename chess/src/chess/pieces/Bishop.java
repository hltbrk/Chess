package chess.pieces;

import chess.ChessBoard;

public class Bishop extends Piece {
    public Bishop(int row, int col, char color) {
        super(row, col, color, 3);
    }


    @Override
    public boolean isThreatening(Piece other) {
        if (other.getColor() == color) return false;
        if (Math.abs(other.getRow() - row) == Math.abs(other.getCol() - col)) {
            ChessBoard board = ChessBoard.getInstance();
            return board.isPathClear(this, other);
        }
        return false;
    }

}
