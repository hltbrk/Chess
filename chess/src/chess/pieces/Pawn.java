package chess.pieces;

public class Pawn extends Piece {
    public Pawn(int row, int col, char color) {
        super(row, col, color, 1);
    }

    @Override
    public boolean isThreatening(Piece target) {
        if (this.color == target.color) return false; // Kendi rengini tehdit etmez

        int rowDiff = target.getRow() - this.row;
        int colDiff = Math.abs(target.getCol() - this.col);

        // Piyonların çapraz tehdit algılamasını sağla
        if (colDiff == 1 && Math.abs(rowDiff) == 1) {
            return true;
        }
        return false;
    }

    public boolean isValidMove(int newRow, int newCol) {
        int rowDiff = newRow - this.row;
        int colDiff = Math.abs(newCol - this.col);

        // Siyah taşlar aşağı (pozitif yöne), beyaz taşlar yukarı (negatif yöne) hareket eder
        if (this.color == 'b') {
            if (rowDiff == 1 && colDiff == 0) return true; // 1 kare düz gitme
            if (this.row == 1 && rowDiff == 2 && colDiff == 0) return true; // İlk hamlede 2 kare gidebilir
        } else {
            if (rowDiff == -1 && colDiff == 0) return true; // 1 kare düz gitme
            if (this.row == 6 && rowDiff == -2 && colDiff == 0) return true; // İlk hamlede 2 kare gidebilir
        }
        return false;
    }
}
