# 🛡️ Java ile Siber Güvenlik Log Analizörü (Konsol Uygulaması)

Bu proje, Java programlama dili kullanılarak geliştirilmiş, nesne yönelimli bir log analiz sistemidir. Farklı ağ katmanlarından gelen verileri sınıflandırarak güvenlik risk skorlarını hesaplar ve siber tehdit tespiti için temel bir altyapı sunar.

## Öne Çıkan Özellikler

*   **Dinamik Log Analizi:** Firewall, Kimlik Doğrulama (Auth) ve Ağ (Network) loglarını türlerine özgü kriterlerle analiz eder.
*   **Akıllı Risk Skorlama:** Her log türü için özelleştirilmiş matematiksel modellerle 0.0 ile 10.0 arasında risk puanı hesaplar.
*   **Kritiklik Seviyesi Raporlama:** Hesaplanan skorlara göre logları "GÜVENLİ", "ŞÜPHELİ" veya "KRİTİK" olarak kategorize eder.
*   **Etkileşimli Menü:** Kullanıcının çalışma anında yeni loglar eklemesine ve anlık analiz raporları almasına olanak tanıyan kullanıcı dostu arayüz.

## Teknik Detaylar

Bu sistem, siber güvenlik dünyasındaki SOC (Security Operations Center) süreçlerinin temel mantığını koda dökmektedir:

*   **Firewall Denetimi:** Kritik portlara (SSH, FTP vb.) yönelik erişim isteklerini denetler.
*   **Brute Force Tespiti:** Hatalı giriş deneme sayılarını analiz ederek hesap güvenliğini kontrol eder.
*   **Veri Sızıntısı Analizi:** Giren ve çıkan veri miktarı arasındaki anomalileri tespit eder.

## Kullanılan Yazılım Mimarisi

Proje, sürdürülebilir ve genişletilebilir bir yapı için **Nesne Yönelimli Programlama (OOP)** prensipleri üzerine inşa edilmiştir:

*   **Kalıtım & Soyutlama (Inheritance & Abstraction):** Tüm log türleri tek bir soyut `Log` sınıfından türetilmiştir.
*   **Çok Biçimlilik (Polymorphism):** `LogManager` sınıfı, farklı türdeki tüm logları tek bir listede işleyebilmektedir.
*   **Kapsülleme (Encapsulation):** Log verileri erişim belirleyicilerle korunarak sistem güvenliği kod seviyesinde sağlanmıştır.

## Nasıl Çalıştırılır?

1.  Bilgisayarınızda bir **Java Geliştirme Kiti (JDK)** kurulu olduğundan emin olun.
2.  Proje dosyalarını bir klasöre çıkartın.
3.  `Main.java` dosyasını VS Code veya tercih ettiğiniz bir IDE ile açın.
4.  `Main.java` dosyasını derleyip çalıştırın.
5.  Terminal ekranındaki yönergeleri izleyerek sisteme log verisi girişi yapabilir ve analiz sonuçlarını görüntüleyebilirsiniz.

---
*Bu proje Bilecik Şeyh Edebali Üniversitesi Bilgisayar Mühendisliği eğitimi kapsamında geliştirilmiştir.*
