import java.util.Scanner;
/*
 * Siber Güvenlik Log Analiz Sistemi'nin ana giriş sınıfıdır.
 * Kullanıcıdan konsol aracılığıyla log verilerini alır, ilgili log nesnelerini
 * oluşturur ve analiz edilmek üzere LogYonetim sistemine aktarır.
 */

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);      // Konsol girdilerini okumak için scanner nesnesi başlatıldı.
        LogYonetim yonetici = new LogYonetim();    // Log ekleme ve analiz işlemlerini üstlenen yönetim sınıfı nesnesi oluşturuldu.

        boolean devamEt = true;     // Konsol menüsünün kontrolünü sağlayan döngü bayrağı.

        System.out.println("\n\n--- SIBER GUVENLIK LOG ANALIZ SISTEMINE HOS GELDINIZ ---");

        while (devamEt) {
            System.out.println("\nEklenecek Log Turunu Seciniz:\n");
            System.out.println("1- Firewall Log");
            System.out.println("2- Auth (Giris) Log");
            System.out.println("3- Network Log");
            System.out.println("4- Analiz Raporunu Goster ve Cık");
            System.out.print("\nSeciminiz: ");
            
            int secim = scan.nextInt();
            scan.nextLine();    // Menü seçiminden kalan Enter (\n) karakterini temizler.

            if (secim == 4) {
                devamEt = false;
                break;
            }

            // Ortak verilerin alınması.
            System.out.print("\nLog ID: ");
            String id = scan.nextLine();
            System.out.print("Kaynak IP: ");
            String ip = scan.nextLine();
            System.out.print("Cihaz Adı: ");
            String cihaz = scan.nextLine();

            // Seçilen log türüne özgü detay verilerin alınması ve nesneye dönüştürülmesi.
            switch (secim) {
                case 1:
                    System.out.print("\nHedef Port: ");
                    int port = scan.nextInt(); 

                    scan.nextLine();          

                    System.out.print("Protokol (TCP/UDP): ");
                    String protokol = scan.nextLine();

                    yonetici.logEkle(new FirewallLog(id, ip, cihaz, port, protokol));       // Polymorphism (Çok Biçimlilik) kullanılarak log yöneticisine ekleme yapılıyor.

                    break;
                case 2:
                    System.out.print("\nKullanıcı Adı: ");
                    String user = scan.nextLine();

                    System.out.print("Hatalı Giriş Deneme Sayısı: ");
                    int deneme = scan.nextInt();
                    scan.nextLine();

                    yonetici.logEkle(new AuthLog(id, ip, cihaz, user, deneme));

                    break;
                case 3:
                    System.out.print("\nÇıkan Veri (MB): ");
                    double cikan = scan.nextDouble();

                    System.out.print("Giren Veri (MB): ");
                    double giren = scan.nextDouble();
                    scan.nextLine();

                    yonetici.logEkle(new NetworkLog(id, ip, cihaz, cikan, giren));

                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }

        // Programdan çıkmadan önce tüm log verilerinin risk analiz çıktısı üretiliyor.
        System.out.println("\n--- ANALİZ BAŞLATILIYOR ---");
        yonetici.tumLoglariAnalizEt();

        System.out.println("# Sistem Kapatılıyor... #");
        scan.close();


    }
}
