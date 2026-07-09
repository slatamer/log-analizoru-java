/*
 * Firewall (Güvenlik Duvarı) loglarını temsil eden ve Log sınıfından türeyen alt sınıftır.
 * Ağ trafiğindeki hedef port ve protokol türüne göre siber güvenlik risk skorlaması yapar. 
 */

public class FirewallLog extends Log {
    private final int port;
    private final String protokol;

    public FirewallLog(String ID, String kaynakIP, String cihazAdi, int port, String protokol) {

        super(ID, kaynakIP, cihazAdi);      // super(): Üst sınıfın (Log) constructor'ını tetikleyerek ortak verileri başlatır.
        this.port = port;
        this.protokol = protokol;
    }

    @Override
    public double riskSkoruHesapla(){

        double skor = 1.0;  // Temel başlangıç skoru.

        // 1. Kriter: Hedef Port Analizi
        if(port == 22 || port == 3389 || port == 23 || port == 1433){    // Yüksek riskli portlar.
            skor += 6.5;
        } else if (port > 1024){    // Orta riskli portlar
            skor += 2.5;   
        }

        // 2. Kriter: Protokol Analizi
        if(protokol.equalsIgnoreCase("UDP")){    // UDP, bağlantısız ve sahte IP'ye müsait bir protokol olduğu için risk çarpanı eklenir.
            skor += 1.0;                                     
        }

        // Risk skorunun siber güvenlik standartları gereği en fazla 10.0 olabilmesini garanti eder.
        return Math.min(skor, 10.0);    // Math.min: Parantez içindeki küçük olan sayıyı seçer.
    }                                     // Bu yapıyı kullanmak risk skoru 10'dan büyük çıksa bile max olarak 10 almamızı sağlar.    

    @Override
    public void logBilgisiniYaz() {
        super.logBilgisiniYaz();
        System.out.println("-> Port: " + port + " | Protokol: " + protokol);
    }
}
