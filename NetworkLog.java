/*
 * Network (Ağ trafik) loglarını temsil eden ve Log sınıfından türeyen alt sınıftır.
 * Giriş/çıkış yapan veri miktarını ve oranlarını analiz ederek veri sızıntısı veya şüpheli veri transferi risklerini skorlar.
 */

public class NetworkLog extends Log{
    private final double cikanVeri;
    private final double girenVeri;

    public NetworkLog(String ID, String kaynakIP, String cihazAdi, double cikanVeri, double girenVeri){
        super(ID, kaynakIP, cihazAdi);
        this.cikanVeri = cikanVeri;
        this.girenVeri = girenVeri;
    }

    @Override
    public double riskSkoruHesapla(){

        double skor = 1.0;      // Temel başlangıç skoru

        // 1. Kriter: Anormal Veri Oranı Analizi
        if(cikanVeri > girenVeri * 5){
            skor += 5.5; 
        } 

        // 2. Kriter: Çıkan Veri Hacmi Analizi
        if(cikanVeri >=500){
            skor += 3.0;
        } else if (cikanVeri >=100){
            skor += 1.5;
        }

        return Math.min(skor, 10.0);
    }

    @Override
    public void logBilgisiniYaz() {
        super.logBilgisiniYaz();
        System.out.println("-> Cikan Veri: " + cikanVeri + " | Giren Veri: " + girenVeri);
    }
}
