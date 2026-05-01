import java.time.LocalDateTime;

// 'abstract' anahtar kelimesi, bu sınıftan doğrudan nesne üretilmesini engeller.
// Yani kimse "boş bir log" oluşturamaz, mutlaka alt sınıflardan (Firewall, Auth vb.) türetilmelidir.

public abstract class Log {
    private String ID;
    private String kaynakIP;
    private String cihazAdi;
    private LocalDateTime zaman;

    public Log (String ID, String kaynakIP, String cihazAdi){
        this.ID = ID;
        this.kaynakIP = kaynakIP;
        this.cihazAdi = cihazAdi;
        this.zaman = LocalDateTime.now();    // Log oluşturulduğu anın tarihini otomatik alır.
    }

    public abstract double riskSkoruHesapla();

    //Private değişkenlere erişim.
    public String getID(){
        return ID;
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
        System.out.println("[" + zaman + "]  ID: " +ID + " | Kaynak: " + kaynakIP + " | Cihaz: " + cihazAdi );
    }
}
