/*
 * Aught (Kimlik doğrulama) loglarını temsil eden ve Log sınıfından türeyen alt sınıftır.
 * Hatalı giriş deneme sayısı ve hedef alınan kullanıcı adına göre Brute-Force (Kaba Kuvvet) saldırı riskini analiz eder.
 */

public class AuthLog extends Log {
    private final String kullaniciAdi;
    private final int denemeSayisi;

    public AuthLog(String ID, String kaynakIP, String cihazAdi, String kullaniciAdi, int denemeSayisi){
        super(ID, kaynakIP, cihazAdi);
        this.kullaniciAdi = kullaniciAdi;
        this.denemeSayisi = denemeSayisi;
    }

    @Override
    public double riskSkoruHesapla(){

        double skor = 1.5;  // Temel başlangıç skoru.

        // 1. Kriter: Hatalı Giriş Deneme Sayısı Analizi (Brute-Force Belirtisi)
        if(denemeSayisi > 20){      // Çok yüksek deneme sayısı = Aktif kaba kuvvet
            skor += 7.5;           
        } else if (denemeSayisi > 5){
            skor += 3.5;
        }

        // 2. Kriter: Hedef Hesap Analizi
        if(kullaniciAdi.equalsIgnoreCase("admin") || kullaniciAdi.equalsIgnoreCase("root")){
            skor += 1.0;        // En yüksek yetkili (root/admin) hesaplar siber saldırganların birincil hedefidir.
        }

        return Math.min(skor, 10.0);
    }

    @Override
    public void logBilgisiniYaz() {
        super.logBilgisiniYaz();
        System.out.println("-> Hedef Kullanıcı: " + kullaniciAdi + " | Hatalı Deneme: " + denemeSayisi + " | Risk Skoru: " + skor);
    }
}
