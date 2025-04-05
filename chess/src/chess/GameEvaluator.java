package chess;

import chess.pieces.Piece;
import java.util.ArrayList;

public class GameEvaluator {
    public static double[] evaluate(ChessBoard board) {
        double whiteScore = 0;
        double blackScore = 0;

        for (Piece piece : board.getPieces()) {
            ArrayList<Piece> threats = board.getThreats(piece);
            boolean isThreatened = !threats.isEmpty();

            double point = piece.getPoint(); // Taşın temel puanı
            double actualPoint = isThreatened ? point / 2.0 : point; // Tehdit altındaysa puanı yarıya düşürme

            // Puanı ilgili tarafa ekleme
            if (piece.getColor() == 'b') {
                whiteScore += actualPoint;
            } else {
                blackScore += actualPoint;
            }
        }

        return new double[]{whiteScore, blackScore};
    }
}
