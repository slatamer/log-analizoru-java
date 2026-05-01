public class AuthLog extends Log {
    private String kullaniciAdi;
    private int denemeSayisi;

    public AuthLog(String ID, String kaynakIP, String cihazAdi, String kullaniciAdi, int denemeSayisi){
        super(ID, kaynakIP, cihazAdi);
        this.kullaniciAdi = kullaniciAdi;
        this.denemeSayisi = denemeSayisi;
    }

    @Override
    public double riskSkoruHesapla(){

        double skor = 1.5;

        if(denemeSayisi > 20){    //çok fazla deneme var kritik risk
            skor += 7.5;           
        } else if (denemeSayisi > 5){
            skor += 3.5;
        }

        if(kullaniciAdi.equalsIgnoreCase("admin") || kullaniciAdi.equalsIgnoreCase("root")){
            skor += 1.0;
        }

        return Math.min(skor, 10.0);
    }
}
