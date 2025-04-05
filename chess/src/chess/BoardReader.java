package chess;

import chess.pieces.*;
import java.io.*;
import java.util.*;

public class BoardReader {
    public static ChessBoard readBoardFromFile(String filePath) throws IOException {
        ChessBoard board = new ChessBoard();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;

        // Her satırı okur ve taşları oluşturur
        while ((line = br.readLine()) != null && row < 8) {
            String[] parts = line.split(" ");
            for (int col = 0; col < parts.length; col++) {
                if (!parts[col].equals("--")) {
                    char type = parts[col].charAt(0); // Taş tipi
                    char color = parts[col].charAt(1); // Taş rengi
                    Piece piece = createPiece(type, row, col, color);
                    if (piece != null) board.addPiece(piece);
                }
            }
            row++;
        }

        br.close();
        return board;
    }

    // Karakterden taş nesnesi üretir
    private static Piece createPiece(char type, int row, int col, char color) {
        switch (type) {
            case 'p': return new Pawn(row, col, color);
            case 'a': return new Knight(row, col, color);
            case 'f': return new Bishop(row, col, color);
            case 'k': return new Rook(row, col, color);
            case 'v': return new Queen(row, col, color);
            case 's': return new King(row, col, color);
            default: return null;
        }
    }
}
