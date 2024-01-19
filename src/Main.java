import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        // Dosya adı ve yolu belirt
        String dosyaAdi = "metinDosyasi.txt";

        try {
            // FileWriter ve BufferedWriter kullanarak dosyayı oluştur
            FileWriter fileWriter = new FileWriter(dosyaAdi);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Dosyaya yazmak istediğiniz metni belirt
            bufferedWriter.write("5\n");
            bufferedWriter.write("10\n");
            bufferedWriter.write("20\n");
            bufferedWriter.write("12\n");
            bufferedWriter.write("33\n");


            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Dosya başarıyla oluşturuldu ve veriler yazıldı.");

            // Dosyadan sayıları okuyup toplamı ekrana yazdır
            int toplam = toplamiHesapla(dosyaAdi);
            System.out.println("Dosyadaki sayıların toplamı: " + toplam);



        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Dosya oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

    private static int toplamiHesapla(String dosyaAdi) throws IOException {
        // FileReader ve BufferedReader kullanarak dosyayı oku
        FileReader fileReader = new FileReader(dosyaAdi);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int toplam = 0;
        String satir;

        // Satır satır dosyayı oku
        while ((satir = bufferedReader.readLine()) != null) {
            // Satırdaki sayıları toplama ekle
            toplam += Integer.parseInt(satir.trim());
        }
        
        bufferedReader.close();
        fileReader.close();

        return toplam;
    }
}