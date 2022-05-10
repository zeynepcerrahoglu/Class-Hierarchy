package proje;

//GeometrikNesne sınıfından kalıtım ile üretilen Daire sınıfı
public class Dikdortgen extends GeometrikNesne {
    
    // Dikdörtgen nesnesinin boy ve en değerlerini tutacak olan 
    // double tipindeki değişkenler
    private double boy;
    private double en;

    // Parametresiz yapıcı(constructor) metot
    // Ödev dökumanında istenildiği gibi en ve boy değerleri 1.0 atanmıştır.
    public Dikdortgen()
    {
        super();
        en = 1.0;
        boy = 1.0;
    }

    // Gerekli parametreleri(verileri) alan 
    // parametreli yapıcı(constructor) metot.
    // Üst sınıf olan GeometrikNesne de tanımlanan değişkenler de 
    // Dikdörtgen sınıfında tanımlanan boy ve en değişkenleriyle birlikte
    // parametre olarak alınmalıdır.
    public Dikdortgen(String theEtiket, Date theTarih,
                      double theBoy, double theEn)
    {
        super(theEtiket, theTarih);
        setBoy(theBoy);
        setEn(theEn);
    }

    
    // Copy constructor olarak adlandırılan yapıcı metot
    public Dikdortgen(Dikdortgen originalObject)
    {
        super(originalObject);
        setEn(originalObject.en);
        setBoy(originalObject.boy);
    }

    
    // Set metotları
    
    // Boy değişkeni için set metodu
    // Boy değişkeni sıfır ya da sıfırdan küçük bir değer girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setBoy(double newBoy) {
        if (newBoy <= 0)
        {
            System.out.println("Error");
            System.exit(0);
        }
        boy = newBoy;
    }

    // En değişkeni için set metodu
    // En değişkeni sıfır ya da sıfırdan küçük bir değer girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setEn(double newEn) {
        if (newEn <= 0)
        {
            System.out.println("Error");
            System.exit(0);
        }
        en = newEn;
    }

    
    // Get metotları
    
    
    // Boy değişkeni için get metodu
    public double getBoy() {
        return boy;
    }

    // En değişkeni için get metodu
    public double getEn() {
        return en;
    }

    
    
    @Override
    // toString metodu Dikdörtgen nesnesinin enini, boyunu ve
    // Üst sınıf olan GeometrikNesne sınıfında yazılan toString
    // metodunu çağırır.
    public String toString() {
        return ("en: "+en + " / boy: " + boy +" "+ super.toString());
    }

    
    // Üst sınıf olan GeometrikNesne sınıfında abstract(soyut) olarak
    // tanımlanan metotların gerçekleştirimleri
    
    
    @Override
    // Çağrlıdığında üzerine çağrıldığı Dikdörtgen nesnesinin
    // alanını hesaplar ve döndürür.
    public double alanHesapla() {
        return (boy*en);
    }

    @Override
    // Çağrıldığında üzerine çağrıldığı Dikdörtgen nesnesinin
    // çevresini hesaplar ve döndürür.
    public double cevreHesapla() {
        return ((boy+en)*2);
    }

    @Override
    // Eğer metodun üzerine çağrıldığı Dikdörtgen nesnesinin alanı
    // parametrede verilen Dikdörtgen nesnesinin alanından büyükse 1
    // Eğer metodun üzerinde çağrıldığı Dikdörtgen nesnesinin alanı 
    // parametrede verilen Dikdörtgen nesnesinin alanından küçükse -1
    // eşitlik durumunda 0 döndürür.
    public int compareTo(Object o) {
        // metodun parametresi Object üst sınıfıdır.
        // işlem yapmak için Object nesnesi Dikdörtgen nesnesine çevirilir.
        Dikdortgen otherDikdortgen = (Dikdortgen) o;
        if (alanHesapla() > otherDikdortgen.alanHesapla())
            return 1;
        else if (alanHesapla() == otherDikdortgen.alanHesapla())
            return 0;
        else
            return -1;
    }
}

