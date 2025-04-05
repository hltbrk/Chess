package chess;

import chess.pieces.*;
import java.util.ArrayList;

public class ChessBoard {
    private ArrayList<Piece> pieces; // Tahtadaki tüm taşlar

    public ChessBoard() {
        pieces = new ArrayList<>();
        instance = this;
    }

    // Singleton benzeri yapı
    private static ChessBoard instance;

    public static ChessBoard getInstance() {
        return instance;
    }

    public void addPiece(Piece piece) {
        piece.setBoard(this); // Taşın ait olduğu tahta ayarlanır
        pieces.add(piece);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    // Belirli bir taşı tehdit eden taşları bulur
    public ArrayList<Piece> getThreats(Piece target) {
        ArrayList<Piece> threats = new ArrayList<>();
        for (Piece p : pieces) {
            if (p.getColor() != target.getColor() && p.isThreatening(target)) {
                threats.add(p);
            }
        }
        return threats;
    }

    // İki taş arasındaki yolun boş olup olmadığını kontrol eder
    public boolean isPathClear(Piece from, Piece to) {
        int dr = Integer.compare(to.getRow(), from.getRow());
        int dc = Integer.compare(to.getCol(), from.getCol());

        int r = from.getRow() + dr;
        int c = from.getCol() + dc;

        // Yol boyunca engel kontrolü
        while (r != to.getRow() || c != to.getCol()) {
            for (Piece p : pieces) {
                if (p.getRow() == r && p.getCol() == c) {
                    return false; // Engel varsa yol kapalı
                }
            }
            r += dr;
            c += dc;
        }
        return true;
    }
}
