# A101-web-automation

![1 f7lT9HSzT2RcVxktn_SeGA](https://user-images.githubusercontent.com/49526501/174499258-8ff63b1a-570a-4f3f-9af5-7e6896e65304.png)

# Projede kullanılan araçlar ve kütüphaneler

Selenium,cucumber,sparkReport,log4j,testng.

# Projenin kapsamı aşağıdaki senaryodur.  

- Senaryoya üye kaydı oluşturmadan devam edilecek.
- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
- Açılan ürünün siyah olduğu doğrulanır.
- Sepete ekle butonuna tıklanır.
- Sepeti Görüntüle butonuna tıklanır.
- Sepeti Onayla butonuna tıklanır.
- Üye olmadan devam et butonuna tıklanır.
- Mail ekranı gelir.
- Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.


# Test Koşması

Testler "resources/testSuites/Chrome.xml" dosyasını çalıştırarak tetiklenir.  
Testler "resources/testSuites/Parallel.xml" dosyasını çalıştırarak tetiklenir.  
Ayrıca ayrı ayrı feature dosyalarından ve test runner üzerinden de çalıştırılabilir.  


Proje paralel koşumu desteklemektedir(Chrome,Firefox).

# Raporlama

Projede Cucumber ve spark report bulunmaktadır.

Raporlar, /Reports/CucumberReport ve /Report/SparkReport klasörleri altında html ve pdf olarak oluşmaktadır.

