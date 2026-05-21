import java.time.LocalDateTime;
/*
 * Sistemdeki tüm log türlerinin türediği soyut temel sınıftır.
 * Bu sınıftan doğrudan nesne üretilemez.
 * Ortak log özelliklerini barındıran ve alt sınıfları kendi risk skorlarını hesaplamaya zorlar.
 */

public abstract class Log {
    private final String id;        // Log verilerinin dışarıdan manipülasyonu (private) ve sonradan değiştirilmesi (final) engelenir.
    private final String kaynakIP;
    private String cihazAdi;
    private final LocalDateTime zaman;

    public Log (String ID, String kaynakIP, String cihazAdi){       // Yeni bir log kaydı başlatmak için kullanılan kurucu metot.
        this.id = ID;
        this.kaynakIP = kaynakIP;
        this.cihazAdi = cihazAdi;
        this.zaman = LocalDateTime.now();    // Logun oluşturulduğu anın zaman damgası otomatik olarak sistemden alınır.
    }

    public abstract double riskSkoruHesapla();      // Her log türü sınıf kendi için bu fonksiyonu ovverride edecek. 

    //Private değişkenlere erişim.
    public String getID(){
        return id;
    }
    public String getKaynakIP(){
        return kaynakIP;
    }
    public String getCihazAdi(){
        return cihazAdi;
    }
    public LocalDateTime getZamanDamgasi() {
        return zaman;
    }
    public void setCihazAdi(String cihazAdi){
        this.cihazAdi = cihazAdi;
    }

    public void logBilgisiniYaz(){
        System.out.println("[" + zaman + "]  ID: " + id + " | Kaynak: " + kaynakIP + " | Cihaz: " + cihazAdi );
    }
}
