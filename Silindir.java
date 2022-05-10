package proje;

//GeometrikNesne sınıfından kalıtım ile üretilen Silindir sınıfı
public class Silindir extends GeometrikNesne {
    
    // Silindir nesnesinin yariçapı ve uzunluk değerlerini tutacak olan 
    // double tipindeki değişkenler
    private double yaricap;
    private double uzunluk;

    
    // Parametresiz yapıcı(constructor) metot
    // Ödev dökumanında istenildiği gibi yariçapı ve 
    // uzunluk değerleri 1.0 atanmıştır.
    public Silindir()
    {
        super();
        yaricap = 1.0;
        uzunluk = 1.0;
    }

    // Gerekli parametreleri(verileri) alan 
    // parametreli yapıcı(constructor) metot.
    // Üst sınıf olan GeometrikNesne de tanımlanan değişkenler de 
    // Silindir sınıfında tanımlanan yariçap ve uzunluk değişkenleriyle birlikte
    // parametre olarak alınmalıdır.
    public Silindir(String theEtiket,
                    Date theTarih, double theYaricap, double theUzunluk)
    {
        super(theEtiket, theTarih);
        setYaricap(theYaricap);
        setUzunluk(theUzunluk);
    }

    // Copy constructor olarak adlandırılan yapıcı metot
    public Silindir(Silindir originalObject)
    {
        super(originalObject);
        setYaricap(originalObject.yaricap);
        setUzunluk(originalObject.uzunluk);
    }

    
    // Get metotları
    
    
    // Uzunluk değişkeni için get metodu
    public double getUzunluk() {
        return uzunluk;
    }

    
    // Yariçap değişkeni için get metodu
    public double getYaricap() {
        return yaricap;
    }

    
    // Set metotları
    
    // Uzunluk değişkeni için set metodu
    // Uzunluk değişkeni sıfır ya da sıfırdan küçük bir değer girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setUzunluk(double newUzunluk) {
        if (newUzunluk <= 0)
        {
            System.out.println("Error");
            System.exit(0);
        }
        uzunluk = newUzunluk;
    }

    
    // Yariçap değişkeni için set metodu
    // Yariçap değişkeni sıfır ya da sıfırdan küçük bir değer girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setYaricap(double yaricap) {
        if (yaricap <= 0)
        {
            System.out.println("Error");
            System.exit(0);
        }
        this.yaricap = yaricap;
    }

    
    
    @Override
    // toString metodu Silindir nesnesinin yariçapını, 
    // uzunluğunu ve Üst sınıf olan 
    // GeometrikNesne sınıfında yazılan toString
    // metodunu geri döndürür.
    public String toString() {
        return ("yaricap: "+ yaricap +" / uzunluk: "+ uzunluk +" "+ super.toString());
    }

    
    // Bu sınıfa özel olarak yazılan metot
    // Silindir nesnesinin hacmini hesaplar ve döndürür.
    public double hacimHesapla()
    {
        return (Math.PI*yaricap*yaricap*uzunluk);
    }

    
    // Üst sınıf olan GeometrikNesne sınıfında abstract(soyut) olarak
    // tanımlanan metotların gerçekleştirimleri
    
    @Override
    // Çağrlıdığında üzerine çağrıldığı Silinidir nesnesinin
    // çevresini hesaplar ve döndürür.
    public double cevreHesapla() {
        return ((2 * 2 * yaricap * Math.PI) + (2 * uzunluk));
    }

    @Override
    // Çağrlıdığında üzerine çağrıldığı Silindir nesnesinin
    // alanını hesaplar ve döndürür.
    public double alanHesapla() {
        return (2 * yaricap *Math.PI * (yaricap + uzunluk));
    }

    @Override
    // Eğer metodun üzerine çağrıldığı Silindir nesnesinin hacmi
    // parametrede verilen Silindir nesnesinin hacminden büyükse 1
    // Eğer metodun üzerinde çağrıldığı Silindir nesnesinin hacmi 
    // parametrede verilen Silindir nesnesinin hacminden küçükse -1
    // eşitlik durumunda 0 döndürür.
    public int compareTo(Object o) {
        // metodun parametresi Object üst sınıfıdır.
        // işlem yapmak için Object nesnesi Silindir nesnesine çevirilir.
        Silindir otherSilindir = (Silindir) o;
        if (hacimHesapla() > otherSilindir.hacimHesapla())
            return 1;
        else if (hacimHesapla() == otherSilindir.hacimHesapla())
            return 0;
        else
            return -1;
    }
}

