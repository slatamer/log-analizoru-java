import java.util.ArrayList;       // esnek/dinamik dizi yapısıdır
import java.util.List;

public class LogYonetim {
    private List<Log> logListesi;      // logListesi adında değişken tanımladık. Tipi:Log. Log sınıfından miras alan nesneleri bir listede tutacağım.

    public LogYonetim(){

        this.logListesi = new ArrayList<>();   // logListesi adında dinamik dizi oluşturdum.
    }

    public void logEkle (Log yeniLog) {
        logListesi.add(yeniLog);
    }

    public void tumLoglariAnalizEt(){
        double skor;
        String seviye;

        System.out.println("\n--GUVENLIK ANALIZ RAPORU--");

        for(int i = 0; i < logListesi.size(); i++){

            Log incelenenLog = logListesi.get(i);
            skor = incelenenLog.riskSkoruHesapla();
            
            if(skor >= 7.5){
                seviye = "KRITIK";
            } else if(skor >= 4.0){
                seviye = "SUPHELI";
            } else {
                seviye = "GUVENLI";
            }

            System.out.println("\n[ " + seviye + " ]");

            incelenenLog.logBilgisiniYaz();

            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}
