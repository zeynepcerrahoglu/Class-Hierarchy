package proje;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

// Deneme, test, demo sınıfı
public class Deneme {

    // Main metot
    public static void main(String[] args) {

        // Dosya okuma işlemleri
        
        // Dosya okumak için oluşturulan objeler
        Scanner fileIn = null;
        File file;
        try {
            file = new File("Input.txt");
            fileIn = new Scanner(new FileInputStream(file)).useLocale(Locale.US);
        //Dosya okunmazsa catch blogu çalışır
        // ve sistemden çıkılır
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        // Proje hakkında soruların sorulduğu forumda denildiği gibi
        // 50 elemanlık tanımlanan dizi.
        // Dizi GeometrikNesne tipinde tanımlanmıştır.
        // input.txt dosyasından okunarak alınan verilerle oluşturulacak
        // nesneler bu dizinin içine sırayla yerleştirilecektir.
        // Sırayla yerleştirilmesi ilk ve son oluşturulan nesnelerin
        // indexleri tutulacağı için önemlidir.
        // Daha sonra bu indexlerle copy constructorlar kullanılacaktır.
        GeometrikNesne[] anaDizi = new GeometrikNesne[50];

        
        // Değişkenler
        
        // anaDizi ye yeni eleman ekleneceği zaman 
        // hangi indexte kalındığını (hangi indexe ekleme yapılması gerektiği)
        // bilgisini tutar.
        // Aynı zamanda kaç tane nesne oluşturulduğunu da tutmuş olur.
        // Programın çeşitli yerlerinde değeri değiştirilir.
        int sayac = 0;
        
        // İlk ve son oluşturulan Daire nesnelerinin indexlerini 
        // tutan değişkenler
        int indexIlkDai = 0, indexSonDai = 0;
        
        // İlk ve son oluşturulan Dikdörtgen nesnelerinin indexlerini 
        // tutan değişkenler
        int indexIlkDik = 0, indexSonDik = 0;
        
        // İlk ve son oluşturulan Silindir nesnelerinin indexlerini 
        // tutan değişkenler
        int indexIlkSil = 0, indexSonSil = 0;
        
        // İlk oluşturulan nesnelerin indexlerinin belirlenmesi için 
        // oluşturulmuş koşullar içerisinde kullanılacak değişkenler
        boolean ilkDaiBulunduMu = false, 
                ilkDikBulunduMu = false, ilkSilBulunduMu = false;


        // Dosya içindeki bilgileri alacak döngü
        while (fileIn.hasNext()) {

            // İlk veriye göre nesnenin hangi sınıftan tanımlanacağı
            // belirlenir
            String cisimTipi = fileIn.next();

            // Eğer Daire nesnesi oluşturulucaksa girilecek koşul
            if (cisimTipi.equals("daire")) {
                
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                
                // Burada Date sınıfından oluşturulacak olan
                // tarih değişkeni için veriler alınmaya başlanacaktır
                // date yazısının bir değişken içinde tutulmasına gerek yoktur.
                fileIn.next();
                
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                
                // veriler alındıktan sonra anaDizi içerisine
                // (en son kalınan indexe)
                // Daire tipinde bir nesne eklenmelidir.
                // Daire sınıfındaki parametreli constructor çalışır
                anaDizi[sayac] = new Daire(etiket, new Date(gun, ay, yil),
                        yaricap);

                
                // İlk oluşturulan Daire nesnesinin indexini tutacak
                // değişken ve bulunduğuna dair bilgiyi tutacak olan 
                // değişkenin değeri değiştirilir
                if ((indexIlkDai == 0) && (!ilkDaiBulunduMu)) {
                    indexIlkDai = sayac;
                    ilkDaiBulunduMu = true;
                }

                // son oluşturulan Daire nesnesinin indexi atanır
                indexSonDai = sayac;

                
            } 
            
            // Eğer Dikdörtgen nesnesi oluşturulucaksa girilecek koşul
            else if (cisimTipi.equals("dikdortgen")) {
                
                String etiket = fileIn.next();
                
                // İlk okunan sayısal değer en,
                // ikincisi boy değeridir
                double en = fileIn.nextDouble();
                double boy = fileIn.nextDouble();
                
                // Burada Date sınıfından oluşturulacak olan
                // tarih değişkeni için verilen alınmaya başlanacaktır
                // date yazısının bir değişken içinde tutulmasına gerek yoktur.
                fileIn.next();
                
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                
                // veriler alındıktan sonra anaDizi içerisine
                // (en son kalınan indexe)
                // Dikdörtgen tipinde bir nesne olarak eklenmelidir.
                // Dikdörtgen sınıfında parametreli constructor çalışır
                anaDizi[sayac] = new Dikdortgen(etiket, new Date(gun, ay, yil),
                        boy, en);

                
                // İlk oluşturulan Dikdörtgen nesnesinin indexini tutacak
                // değişken ve bulunduğunda dair bilgiyi tutacak olan 
                // değişkenin değeri değiştirilir
                if ((indexIlkDik == 0) && (!ilkDikBulunduMu)) {
                    indexIlkDik = sayac;
                    ilkDikBulunduMu = true;
                }

                // son oluşturulan Dikdörtgen nesnesinin indexi atanır
                indexSonDik = sayac;

            } 
            // Eğer Silindir nesnesi oluşturulucaksa girilecek koşul
            else if (cisimTipi.equals("silindir")) {
                
                String etiket = fileIn.next();
                
                // İlk okunan sayılsal değer yarıçap
                // ikincisi uzunluktur.
                // Değişkenlerin okuma sırasındaki yerleri değiştirilirse
                // alan, çevre ve hacim hesaplamalarında farklılıklar
                // olabilir.
                double yaricap = fileIn.nextDouble();
                double uzunluk = fileIn.nextDouble();
                
                // Burada Date sınıfından oluşturulacak olan
                // tarih değişkeni için verilen alınmaya başlanacaktır
                // date yazısının bir değişken içinde tutulmasına gerek yoktur.
                fileIn.next();
                
                
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                // veriler alındıktan sonra anaDizi içerisine
                // (en son kalınan indexe)
                // Silindir tipinde bir nesne olarak eklenmelidir.
                // Silindir sınıfında parametreli constructor çalışır
                anaDizi[sayac] = new Silindir(etiket, new Date(gun, ay, yil),
                        yaricap, uzunluk);

                // İlk oluşturulan Silindir nesnesinin indexini tutacak
                // değişken ve bulunduğunda dair bilgiyi tutacak olan 
                // değişkenin değeri değiştirilir
                if ((indexIlkSil == 0) && (!ilkSilBulunduMu)) {
                    indexIlkSil = sayac;
                    ilkSilBulunduMu = true;
                }

                // son oluşturulan Silindir nesnesinin indexi atanır
                indexSonSil = sayac;

            } 
            // Satır başına gelindiğinde tanımlanmış nesne ismimleri dışında
            // başka bir veri gelirse hata mesajı yazdırılır ve 
            // program sonlanır
            else{
                System.out.println("Yanlış veri girildi.");
                System.exit(0);
            }  
            
            // Sayac değişkeni hem anaDizide kalınan indexi 
            // hem de anaDizi içinde tutulan nesne sayısını tutacağı için 
            // while döngüsünün sonunda bir arttırılmalıdır.
            sayac++;

           
        }
        
   
        // Copy constructor kullanılarak yeni nesneler oluşturulacak kısım.
        // Ödev kağıdında üç tane yeni nesne oluşturulması istenmiştir.
        
        // sayaç değişkeni, anaDizide kalınan yere yeni nesnenin atılması için 
        // ve yeni oluşturulan nesnelerin indexlerini tutacak 
        // olan değişkenlere atama yapılması için kullanılır.
        
        // Son Daire nesnesinden yeni Daire nesnesi oluşturma
        anaDizi[sayac] = new Daire((Daire) anaDizi[indexSonDai]);
        
        // Yeni oluşturulan Daire nesnesinin
        // (yeni oluşturulan Daire nesnesi artık son Daire nesnesi olmuş olur)
        // indexini tutmak için yeni bir değişken tanımlanır
        int indexKopyaDai = sayac;
        
        // Son Dikdörtgen nesnesinden yeni Dikdörtgen nesnesi oluşturma
        anaDizi[sayac + 1] = new Dikdortgen((Dikdortgen) anaDizi[indexSonDik]);
        
        // Yeni oluşturulan Dikdörtgen nesnesinin
        // (yeni oluşturulan Dikdörtgen nesnesi artık 
        // son Dikdörtgen nesnesi olmuş olur)
        // indexini tutmak için yeni bir değişken tanımlanır
        int indexKopyaDik = sayac + 1;
        
        // Son Silindir nesnesinden yeni Silindir nesnesi oluşturma
        anaDizi[sayac + 2] = new Silindir((Silindir) anaDizi[indexSonSil]);
        
        // Yeni oluşturulan Silindir nesnesinin
        // (yeni oluşturulan Silindir nesnesi artık 
        // son Silindir nesnesi olmuş olur)
        // indexini tutmak için yeni bir değişken tanımlanır
        int indexKopyaSil = sayac + 2;

        
        // Sayaç değişkeni üç tane yeni nesne oluşturulduğu için 
        // üç arttırılır.
        // Eğer anaDiziye sonradan ekleme yapılacaksa değerinin arttırılması
        // gerektiği unutulmamalıdır.
        sayac += 3;

        
        // Sırasıyla, çevre ortalaması(tüm geometrik nesneler göz önüne alınarak), 
        // alan ortalaması (tüm geometrik nesneler göz önüne alınarak), 
        // hacim ortalaması (silindirler göz önüne alınarak), 
        // en küçük çevre değeri, en büyük çevre değeri, 
        // en küçük alan değeri, en büyük alan değeri, 
        // en küçük hacim değeri ve en büyük hacim değeri gibi hesaplamaları 
        // tutacak olan tek boyutlu dizi
        double[] hesaplar = new double[9];
        
        // Hesaplar dizisine eklenecek olan üç ortalama değerini
        // belirleyebilmek için ilk önce toplam çevre,
        // toplam alan ve toplam hacim değerleri bulunmalıdır.
        // Bulunan değerler bu değişkenlerde tutulacaktır.
        double cevreToplam = 0, alanToplam = 0, hacimToplam = 0;
        
        // Hacim ortalaması sadece silindir sınıfı için geçerlidir.
        // Bu yüzden silindirlerin sayısı hesaplanmalıdır.
        // Döngü içerisinde değişkenin değeri arttırılacaktır.
        // Değişken silindir sayısını ortalama hesaplamak için tutar.
        int silidirSayi = 0;

        
        // polymorphicYazdir metodu main içinde çağrılmalıdır.
        // Nesne bilgisini, cevre ve alan değerileri yazdırılır.
        // Eğer nesne Silindir ise hacim bilgisi de yazdırılır.
        // Metot yazdırılırken döngü içinde
        // bir yandan ortalama hesaplamak ve
        // en büyük, en küçük gibi verileri 
        // alıp hesaplar isimli tek boyutlu diziye 
        // eklemek için veriler toplanır.
        System.out.println("\nPolymorphic Yazdırma");
        System.out.println("--------------------\n");
        for (GeometrikNesne nesne : anaDizi) {
            
            // anaDizi tamamen doldurulmamış olabilir
            if (nesne != null) {

                
                polymorphicYazdir(nesne);

                
                // metotları tekrar tekrar çağrımamak için 
                // ihtiyacımız olan verileri aşağıdaki 
                // değişkenler içinde tutarız.
                double nesneCevre = nesne.cevreHesapla();
                double nesneAlan = nesne.alanHesapla();

                cevreToplam += nesneCevre;
                alanToplam += nesneAlan;

                // en küçük çevre 
                if ((hesaplar[3] >nesneCevre) || (hesaplar[3] == 0))
                    hesaplar[3] = nesneCevre;

                // en büyük çevre
                if (hesaplar[4] <nesneCevre)
                    hesaplar[4] = nesneCevre;

                // en küçük alan
                if ((hesaplar[5] > nesneAlan) || (hesaplar[5] == 0))
                    hesaplar[5] = nesneAlan;

                // en büyük alan
                if (hesaplar[6] < nesneAlan)
                    hesaplar[6] = nesneAlan;

                // Nesne Silindir ise
                if (nesne.getClass() == Silindir.class) {
                    
                    silidirSayi++;

                    // Silindir nesnesinin hacim değeri
                    // metot çağrılarak elde edilir
                    double nesneHacim = ((Silindir) nesne).hacimHesapla();

                    hacimToplam += nesneHacim;

                    // en büyük hacim
                    if (hesaplar[8] < nesneHacim)
                        hesaplar[8] = nesneHacim;

                    // en küçük hacim
                    if ((hesaplar[7] > nesneHacim) || (hesaplar[7] == 0))
                        hesaplar[7] = nesneHacim;
                }
            }

        }

        
        // hesaplar dizisine ortalama çevre, alan ve hacim bilgileri
        // hesaplanır ve aktarılır.
        // sayaç değişekeni kaç tane nesne olduğu bilgisini
        // tuttuğu için kullanılır.
        hesaplar[0] = cevreToplam / (sayac);
        hesaplar[1] = alanToplam / (sayac);
        hesaplar[2] = hacimToplam / silidirSayi;

        // Karşılaştır metotu ödev kağıdında istenilen kadar ve 
        // istenilen şekilde çağrılmıştır.
        // Son oluşturulan nesneler copy constructor la oluşturulanlardır
        // Metottan -1, 1, 0 şeklinde değerler yazdırılacaktır
        // Çıktıda hem nesnelerin bilgileri hem de bu sayılar görülecektir
        System.out.println("\nKarşılaştırma");
        System.out.print("-------------");
        
        // ilk ve son daire
        karsilastir(anaDizi[indexIlkDai], anaDizi[indexKopyaDai]);
        
        // son ve sondan bir önceki daire
        karsilastir(anaDizi[indexKopyaDai], anaDizi[indexSonDai]);
        
        // ilk ve son dikdörtgen
        karsilastir(anaDizi[indexIlkDik], anaDizi[indexKopyaDik]);
        
        // son ve sondan bir önceki dikdörtgen
        karsilastir(anaDizi[indexKopyaDik], anaDizi[indexSonDik]);
        
        // ilk ve son silindir
        karsilastir(anaDizi[indexIlkSil], anaDizi[indexKopyaSil]);
        
        // son ve sondan bir önceki silindir
        karsilastir(anaDizi[indexKopyaSil], anaDizi[indexSonSil]);

        
        // Oluşturulan ve çeşitli hesaplamaları içinde barındıran
        // tek boyutlu hesaplar dizisinin elemanları
        // sırasıyla ekrana yazdırılacaktır.
        // Elemanlar ödev kağındında belirtildiği şekilde tutulmuşur.
        // Sırasıyla,
        // çevre ortalamsı
        // alan ortalaması
        // hacim ortalaması
        // en küçük çevre değeri
        // en büyük çevre değeri
        // en küçük alan değeri
        // en büyük alan değeri
        // en küçük hacim değeri
        // en büyük hacim değeri yazdırılır
        System.out.println("\n\nHesaplar isimli tek boyutlu dizi");
        System.out.print("--------------------------------");
        for (double hesap : hesaplar) {
            System.out.printf("\n%,.3f", hesap);
        }
        System.out.println();


    }

    // GeometrikNesne tipinde parametre alan static metot
    // Parametre olarak gelen nesnenin bilgilerini,
    // çevre ve alan değerlerini yazdırır.
    // Nesne Silindir ise hacim değeri de yazdırılır.
    // Void metot olduğu için yazdırılması gereken bilgiler 
    // içindeki print işlemleri tarafından yapılacaktır.
    public static void polymorphicYazdir(GeometrikNesne nesne)
    {
        System.out.println("Nesne: "+ nesne.toString());
        System.out.println("-----");
        System.out.printf("Alan: %,.3f ", nesne.alanHesapla());
        System.out.printf("\nÇevre: %,.3f ", nesne.cevreHesapla());
        
        // Nesne Silindir ise
        if(nesne.getClass() == Silindir.class)
        {
            Silindir newSilindir = (Silindir) nesne;
            System.out.printf("\nHacim: %,.3f", newSilindir.hacimHesapla());
        }
        System.out.println();
        System.out.println();


    }
    
    
    // GeometrikNesne tipinde iki adet parametre alan static metot.
    // compareTo metodu kullanır.
    // main içinden çağrılmışıtır.
    // Void metot olduğu için yazdırılması gereken bilgiler 
    // içindeki print işlemleri tarafından yapılacaktır.
    // Nesnelerin bilgileri ve compareTo dan dönen sonuç yazdırılır.
    public static void karsilastir(GeometrikNesne nesne1, GeometrikNesne nesne2)
    {
        int sonuc = nesne1.compareTo(nesne2);
        System.out.println("\nMetotdun çağrıldığı nesne: " + nesne1.toString());
        System.out.println("Metotda parametre olarak verilen nesne: " + nesne2.toString());
        System.out.println("Sonuç: " + sonuc);
    }


}

