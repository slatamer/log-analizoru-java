public class FirewallLog extends Log {
    private int port;
    private String protokol;

    public FirewallLog(String ID, String kaynakIP, String cihazAdi, int port, String protokol) {
        // 'super' anahtar kelimesiyle üst sınıfın (Log) constructor'ını çağırıyoruz.
        super(ID, kaynakIP, cihazAdi);
        this.port = port;
        this.protokol = protokol;
    }

    @Override
    public double riskSkoruHesapla(){

        double skor = 1.0;  //temel başlangıç skoru

        if(port == 22 || port == 3389 || port == 23 || port == 1433){    //yüksek riskli portlar
            skor += 6.5;
        } else if (port > 1024){    //orta riskli portlar
            skor += 2.5;   //standart web trafiği
        }

        if(protokol.equalsIgnoreCase("UDP")){    // Bu trafik UDP üzerinden geliyor.
            skor += 1.0;                                       // Kaynağından emin olamayabilirim ve bu bir saldırının parçası olabilir, bu yüzden risk seviyesini biraz daha yukarı çekmeliyim.
        }

        return Math.min(skor, 10.0);    // Math.min -> parantez içindeki küçük olan sayıyı seçer. 
    }                                     // Bu yapıyı kullanmak risk skoru 10'dan büyük çıksa bile max olarak 10 almamızı sağlar.
}
