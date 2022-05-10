package proje;


//GeometrikNesne sınıfından kalıtım ile üretilen Daire sınıfı
public class Daire extends GeometrikNesne{
    
    // Daire nesnesinin yarıçapını tutacak double 
    // tipinde değişken
    private double yaricap;
    
    // Gerekli parametreleri(verileri) alan 
    // parametreli yapıcı(constructor) metot.
    // Üst sınıf olan GeometrikNesne de tanımlanan değişkenler de 
    // Daire sınıfında tanımlanan yarıçap değişkeniyle birlikte
    // parametre olarak alınmalıdır.
    public Daire(String theEtiket,
                 Date theTarih, double theYaricap)
    {
        super(theEtiket, theTarih);
        setYaricap(theYaricap);
    }

    // Parametresiz yapıcı(constructor) metot
    // Ödev dökumanında istenildiği gibi yarıçap değeri 1.0 atanmıştır.
    public Daire()
    {
        super();
        yaricap = 1.0;
    }

    // Copy constructor olarak adlandırılan yapıcı metot
    public Daire(Daire originalObject)
    {
        super(originalObject);
        setYaricap(originalObject.yaricap);
    }

    // Yarıçap değişkeni için set metodu
    // Yarıçap değişkeni sıfır ya da sıfırdan küçük bir değer girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setYaricap(double newYaricap)
    {
        if (newYaricap <= 0)
        {
            System.out.println("Error");
            System.exit(0);
        }
        yaricap = newYaricap;
    }
    
    
    // Yarıçap değişkeni için get metodu 
    public double getYaricap()
    {
        return yaricap;
    }

   
    @Override
    // toString metodu Daire nesnesinin yarıçapını ve
    // Üst sınıf olan GeometrikNesne sınıfında yazılan toString
    // metodunu çağırır.
    public String toString()
    {
        return ("yaricap: "+yaricap+" "+super.toString());
    }

    
    // Üst sınıf olan GeometrikNesne sınıfında abstract(soyut) olarak
    // tanımlanan metotların gerçekleştirimleri
    
    @Override
    // Çağrlıdığında üzerine çağrıldığı Daire nesnesinin
    // alanını hesaplar ve döndürür.
    public double alanHesapla()
    {
        return (yaricap*yaricap*Math.PI);
    }

    
    @Override
    // Çağrıldığında üzerine çağrıldığı Daire nesnesinin
    // çevresini hesaplar ve döndürür.
    public double cevreHesapla()
    {
        return (2*Math.PI*yaricap);
    }

    @Override
    // Eğer metodun üzerine çağrıldığı Daire nesnesinin yarıçapı
    // parametrede verilen Daire nesnesinin yarıçapından büyükse 1
    // Eğer metodun üzerinde çağrıldığı Daire nesnesinin yarıçapı 
    // parametrede verilen Daire nesnesinin yarıçapından küçükse -1
    // eşitlik durumunda 0 döndürür.
    public int compareTo(Object o) {
        // metodun parametresi Object üst sınıfıdır.
        // işlem yapmak için Object nesnesi Daire nesnesine çevirilir.
        Daire otherDaire = (Daire) o;
        if(yaricap > otherDaire.yaricap)
            return 1;
        else if (yaricap == otherDaire.yaricap)
            return 0;
        else
            return -1;
    }
}


