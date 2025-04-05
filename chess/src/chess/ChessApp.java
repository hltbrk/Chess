package chess;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ChessApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame(" Satranç Tahta Analizi ");
            frame.setSize(700, 780);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(10, 10));
            frame.getContentPane().setBackground(Color.decode("#2E3440"));

            // Tahta yükleme butonu
            JButton btnLoad = new JButton("Tahta Yükle");
            btnLoad.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btnLoad.setBackground(new Color(0x5E81AC));
            btnLoad.setForeground(Color.WHITE);
            btnLoad.setFocusPainted(false);
            btnLoad.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btnLoad.setToolTipText("Bir satranç pozisyon dosyası yükleyin");

            // Sonuç etiketi puanları gösterildiği yer
            JLabel lblResult = new JLabel("Henüz hesaplanmadı.", SwingConstants.CENTER);
            lblResult.setFont(new Font("Segoe UI", Font.BOLD, 18));
            lblResult.setForeground(new Color(0xECEFF4));
            lblResult.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Üst panel yani buton ve skor etiketi içerir
            JPanel topPanel = new JPanel(new BorderLayout(10, 10));
            topPanel.setBackground(Color.decode("#2E3440"));
            topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            topPanel.add(btnLoad, BorderLayout.WEST);
            topPanel.add(lblResult, BorderLayout.CENTER);

            // Tahta paneli  satranç tahtası görseli
            final ChessBoardPanel[] boardPanel = {new ChessBoardPanel(new ChessBoard())};
            JPanel boardWrapper = new JPanel();
            boardWrapper.setBackground(Color.decode("#2E3440"));
            boardWrapper.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
            boardWrapper.add(boardPanel[0]);

            // Panele  tahtayı ekleme
            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(boardWrapper, BorderLayout.CENTER);

            // dosya seçme ekranı
            btnLoad.addActionListener(e -> {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        // Dosyadan tahta bilgisi okunur ve analiz edilir
                        ChessBoard board = BoardReader.readBoardFromFile(file.getAbsolutePath());
                        double[] scores = GameEvaluator.evaluate(board);
                        lblResult.setText(String.format(" Beyaz: %.1f     Siyah: %.1f", scores[0], scores[1]));

                        // Eski tahtayı kaldırır yenisiyle değiştirir
                        boardWrapper.remove(boardPanel[0]);
                        boardPanel[0] = new ChessBoardPanel(board);
                        boardWrapper.add(boardPanel[0]);
                        boardWrapper.revalidate();
                        boardWrapper.repaint();
                    } catch (Exception ex) {
                        lblResult.setText(" Dosya okunamadı!");
                        ex.printStackTrace();
                    }
                }
            });

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
