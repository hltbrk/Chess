package chess;

import chess.pieces.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChessBoardPanel extends JPanel {
    private static final int TILE_SIZE = 64;
    private static final int BOARD_SIZE = 8;
    private ArrayList<Piece> pieces;
    private ChessBoard board;

    public ChessBoardPanel(ChessBoard board) {
        this.board = board;
        this.pieces = board.getPieces();
        setPreferredSize(new Dimension(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE));
        setBackground(Color.decode("#2E3440"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Karelerin renkleri
        Color lightColor = new Color(0xBEBEBB);
        Color darkColor = new Color(0x769656);

        // Satranç tahtasını çiz
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                boolean isLight = (row + col) % 2 == 0;
                g.setColor(isLight ? lightColor : darkColor);
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        // Taşları çiz
        for (Piece piece : pieces) {
            boolean isThreatened = !board.getThreats(piece).isEmpty();
            drawPiece(g, piece, isThreatened);
        }
    }

    // Taş sembollerini çizme
    private void drawPiece(Graphics g, Piece piece, boolean isThreatened) {
        int x = piece.getCol() * TILE_SIZE;
        int y = piece.getRow() * TILE_SIZE;

        String symbol = getPieceSymbol(piece);
        g.setFont(new Font("Serif", Font.PLAIN, 48));
        g.setColor(piece.getColor() == 'b' ? Color.WHITE : Color.BLACK);

        // Ortalanmış şekilde sembolü yaz
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(symbol);
        int textHeight = fm.getAscent();
        g.drawString(symbol, x + (TILE_SIZE - textWidth) / 2, y + (TILE_SIZE + textHeight) / 2 - 4);

        // Tehdit altındaki taşları  kırmızı çember ile gösteren yer
        if (isThreatened) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(2));
            g2.drawOval(x + 6, y + 6, TILE_SIZE - 12, TILE_SIZE - 12);
        }
    }

    // Taş tipine göre sembol döndür
    private String getPieceSymbol(Piece piece) {
        boolean isWhite = piece.getColor() == 'b';

        if (piece instanceof Pawn)   return isWhite ? "♙" : "♟";
        if (piece instanceof Knight) return isWhite ? "♘" : "♞";
        if (piece instanceof Bishop) return isWhite ? "♗" : "♝";
        if (piece instanceof Rook)   return isWhite ? "♖" : "♜";
        if (piece instanceof Queen)  return isWhite ? "♕" : "♛";
        if (piece instanceof King)   return isWhite ? "♔" : "♚";
        return "?";
    }
}
