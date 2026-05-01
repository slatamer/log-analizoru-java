import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        LogYonetim yonetici = new LogYonetim();

        boolean devamEt = true;

        System.out.println("\n\n--- SİBER GÜVENLİK LOG ANALİZ SİSTEMİNE HOŞ GELDİNİZ ---");

        while (devamEt) {
            System.out.println("\nEklenecek Log Türünü Seçiniz:\n");
            System.out.println("1- Firewall Log");
            System.out.println("2- Auth (Giriş) Log");
            System.out.println("3- Network Log");
            System.out.println("4- Analiz Raporunu Göster ve Çık");
            System.out.print("\nSeçiminiz: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluk karakterini temizlemek için

            if (secim == 4) {
                devamEt = false;
                break;
            }

            // Ortak verileri alalım
            System.out.print("\nLog ID: ");
            String id = scanner.nextLine();
            System.out.print("Kaynak IP: ");
            String ip = scanner.nextLine();
            System.out.print("Cihaz Adı: ");
            String cihaz = scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("\nHedef Port: ");
                    int port = scanner.nextInt(); 

                    scanner.nextLine();          // KRİTİK: Tampon bellekteki Enter karakterini temizle

                    System.out.print("Protokol (TCP/UDP): ");
                    String protokol = scanner.nextLine();

                    yonetici.logEkle(new FirewallLog(id, ip, cihaz, port, protokol));  
                    break;
                case 2:
                    System.out.print("\nKullanıcı Adı: ");
                    String user = scanner.nextLine();

                    System.out.print("Hatalı Giriş Deneme Sayısı: ");
                    int deneme = scanner.nextInt();

                    yonetici.logEkle(new AuthLog(id, ip, cihaz, user, deneme));
                    break;
                case 3:
                    System.out.print("\nÇıkan Veri (MB): ");
                    double cikan = scanner.nextDouble();

                    System.out.print("Giren Veri (MB): ");
                    double giren = scanner.nextDouble();

                    yonetici.logEkle(new NetworkLog(id, ip, cihaz, cikan, giren));
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }

        // Programdan çıkmadan önce tüm logları analiz et
        yonetici.tumLoglariAnalizEt();
        System.out.println("# Sistem Kapatılıyor... #");
        scanner.close();


    }
}
