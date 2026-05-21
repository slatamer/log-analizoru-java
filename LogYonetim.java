import java.util.ArrayList;
import java.util.List;
/*
 * Sistemdeki tüm logların merkezi yönetimini ve analizini üstlenen sınıftır.
 * Polymorphism (Çok biçimlilik) kullanarak farklı log türlerini tek bir listede 
 * toplar ve ortak risk değerlendirme kriterlerine göre raporlar.
 */

public class LogYonetim {
    
    private List<Log> logListesi;      // Log sınıfından türeyen tüm nesneleri bir arada tutan dinamik liste.
                                      // (logListesi adında değişken tanımladık) (Tipi: Log)

    public LogYonetim(){

        this.logListesi = new ArrayList<>();    // Log yönetim sistemini başlatan ve bellek üzerinde dinamik diziyi (ArrayList) ayıran constructor.
    }

    public void logEkle (Log yeniLog) {
        logListesi.add(yeniLog);
    }

    public void tumLoglariAnalizEt(){
        System.out.println("\n--GUVENLIK ANALIZ RAPORU--");

        for(Log incelenenLog : logListesi){     // for-each dögüsü, logListesi içindeki her bir Log nesnesini sırayla getir ve döngü boyunca ona incelenenLog adını ver.

            double skor = incelenenLog.riskSkoruHesapla();
            String seviye;

            if (skor >= 7.5) {
                seviye = "KRITIK";
            } 
            else if (skor >= 4.0) {
                seviye = "SUPHELI";
            } 
            else {
                seviye = "GUVENLI";
            }

            System.out.println("\n[ " + seviye + " ]");

            incelenenLog.logBilgisiniYaz();

            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}
