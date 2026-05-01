public class NetworkLog extends Log{
    private double cikanVeri;
    private double girenVeri;

    public NetworkLog(String ID, String kaynakIP, String cihazAdi, double cikanVeri, double girenVeri){
        super(ID, kaynakIP, cihazAdi);
        this.cikanVeri = cikanVeri;
        this.girenVeri = girenVeri;
    }

    @Override
    public double riskSkoruHesapla(){

        double skor = 1.0;

        if(cikanVeri > girenVeri * 5){
            skor += 5.5; 
        } 

        if(cikanVeri >=500){
            skor += 3.0;
        } else if (cikanVeri >=100){
            skor += 1.5;
        }

        return Math.min(skor, 10.0);
    }
}
