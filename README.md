#  Java Satranç Tahtası Uygulaması

Bu proje, Java programlama diliyle nesne yönelimli olarak geliştirilmiş basit bir **satranç tahtası simülasyonudur**. Uygulama, bir `.txt` dosyasından satranç taşlarını okuyarak tahtaya yerleştirir, her taşın tehdit ettiği taşları belirler ve tehdit durumuna göre puan hesaplaması yapar.

##  Proje Yapısı



##  Başlangıç

### IntelliJ IDEA ile

1. `chess` klasörünü IntelliJ IDEA'da açın.
2. `src` klasörünü **Sources Root** olarak işaretleyin.
3. `ChessApp.java` dosyasını açıp çalıştırın (`Run > Run 'ChessApp'`).
4. Giriş dosyası olarak aynı klasöre bir `board.txt` dosyası koyabilirsiniz.

### Komut Satırından Derleme ve Çalıştırma



ks as fs vs ss fs -- ks
ps ps ps ps -- ps ps ps
-- -- -- -- -- as -- --
-- ab -- -- ps -- -- --
-- -- -- pb -- -- -- --
-- -- -- -- -- -- -- --
pb pb pb -- pb pb pb pb
kb -- fb vb sb fb ab kb

örnek txt içeriği
böyle olmalıdır

```bash
cd C:\Users\Huawei\Desktop\chess
javac -d out src/chess/*.java src/chess/pieces/*.java
java -cp out chess.ChessApp


