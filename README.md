# 🛡️ Java ile Siber Güvenlik Log Analizörü (Konsol Uygulaması)

Bu proje, Java programlama dili kullanılarak geliştirilmiş, **Nesne Yönelimli Programlama (OOP)** prensiplerine dayalı bir log analiz sistemidir. Farklı ağ katmanlarından gelen verileri sınıflandırır, güvenlik risk skorlarını hesaplar ve siber tehdit tespiti için temel bir SOC (Security Operations Center) altyapısı sunar.

---

## Öne Çıkan Özellikler

*   ** Dinamik Analiz:** Firewall, Kimlik Doğrulama (Auth) ve Ağ (Network) loglarını türlerine özgü kriterlerle inceler.
*   ** Akıllı Skorlama:** Her log türü için 0.0 - 10.0 arasında özelleştirilmiş risk puanlaması yapar.
*   ** Anlık Raporlama:** Hesaplanan skorlara göre logları anında kategorize eder.
*   ** Etkileşimli Arayüz:** Kullanıcı dostu konsol menüsü ile çalışma anında veri girişi ve analiz imkanı sağlar.

---

## Teknik Detaylar & Risk Analizi

Sistem, siber güvenlik dünyasındaki SOC süreçlerini şu üç ana başlıkta simüle eder:

| Log Türü | Analiz Kapsamı | Örnek Senaryo |
| :--- | :--- | :--- |
| **Firewall** | Port denetimi | Kritik portlara (SSH, FTP) erişim istekleri. |
| **Auth** | Brute Force tespiti | Hatalı giriş deneme sayılarının analizi. |
| **Network** | Veri Sızıntısı (Exfiltration) | Giren/Çıkan veri miktarı arasındaki anomaliler. |

### ⚠️ Risk Seviyeleri
| Skor Aralığı | Durum |
| :--- | :--- |
| **0.0 - 4.0** | ✅ GÜVENLİ |
| **4.0 - 7.5** | ⚠️ ŞÜPHELİ |
| **7.5 - 10.0** | 🚨 KRİTİK |

---

## Kullanılan Yazılım Mimarisi (OOP)

Proje, sürdürülebilir ve genişletilebilir bir yapı için şu prensipler üzerine inşa edilmiştir:

*   **Kalıtım & Soyutlama (Inheritance & Abstraction):** Tüm log türleri, ortak özellikleri barındıran soyut bir `Log` sınıfından türetilmiştir.
*   **Çok Biçimlilik (Polymorphism):** `LogYonetim` sınıfı, farklı türdeki tüm logları tek bir `ArrayList` içinde dinamik olarak işleyebilir.
*   **Kapsülleme (Encapsulation):** Log verileri `private` erişim belirleyicilerle korunarak veri bütünlüğü sağlanmıştır.

---

## Nasıl Çalıştırılır?

1.  Bilgisayarınızda bir **Java Geliştirme Kiti (JDK)** kurulu olduğundan emin olun.
2.  Proje dosyalarını bir klasöre çıkartın.
3.  `Main.java` dosyasını VS Code veya tercih ettiğiniz bir IDE ile açın.
4.  `Main.java` dosyasını derleyip çalıştırın.
5.  Terminal ekranındaki yönergeleri izleyerek sisteme log verisi girişi yapabilir ve analiz sonuçlarını görüntüleyebilirsiniz.
