package chess.pieces;

import chess.ChessBoard;


// Taşların ortak sınıfı özelliklerinin falan belirlendiği yer

public abstract class Piece {
    protected int row, col;
    protected char color;
    protected double point;
    protected ChessBoard board; // 👈 TAHTA REFERANSI

    public Piece(int row, int col, char color, double point) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.point = point;
    }

    // TAŞA TAHTAYI ATAMAK İÇİN
    public void setBoard(ChessBoard board) {
        this.board = board;
    }


    public boolean isOpponent(Piece other) {
        return other != null && this.color != other.color;
    }


    public abstract boolean isThreatening(Piece other);

    public char getColor() { return color; }

    public double getPoint() { return point; }

    public int getRow() { return row; }

    public int getCol() { return col; }
}
