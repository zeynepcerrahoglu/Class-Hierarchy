package proje;

// Geometrik nesneleri genel olarak temsil eder
// Soyut(abstract) bir sınıftır.
// Comparable arayüzünü gerçekleştirir.
public abstract class GeometrikNesne implements Comparable<Object> {
    
    // Nesneye verilen etiket ismini (dai1 gibi) tutmak için 
    // kullanılan String tipindeki değişken
    private String etiket;
    
    // Nesnenin oluşturulma tarihini tutmak için kullanacağımız
    // Date sınıfı tipindeki değişken
    private Date tarih;

    
    // Soyut(abstract) metotların imzaları
    public abstract double alanHesapla();
    public abstract double cevreHesapla();
    @Override
    public abstract int compareTo(Object o);


    // Parametresiz yapıcı(constructor) metot
    // etiket değişkeni no name ile oluşturulur
    // tarih değişkeni oluşturulurken
    // Date sınıfındaki parametresiz yapıcı metot kullanılmıştır.
    public GeometrikNesne()
    {
        etiket = "No name";
        tarih = new Date();
    }

    // Gerekli parametreleri(verileri) alan 
    // parametreli yapıcı(constructor) metot.
    public GeometrikNesne(String theEtiket, Date theDate)
    {
        setEtiket(theEtiket);
        setTarih(theDate);
    }

    
    // Copy constructor olarak adlandırılan yapıcı metot
    // Privacy Leak olmasını önlemek için alınan önlem 
    // set ve get metotlarında yapılmışıtır
    // Privacy Leak oluşmasına sebep olabilecek değişken 
    // Date tipindeki tarih değişkenidir.
    public GeometrikNesne(GeometrikNesne originalObject)
    {
        if (originalObject == null)
        {
            System.out.println("Error");
            System.exit(0);
        }
        setEtiket(originalObject.etiket);
        setTarih(originalObject.tarih);
    }

    
    // Set metotları
    
    
    // Etiket değişkeni için set metodu
    // Etiket değişkeni null girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setEtiket(String newEtiket)
    {
        if(newEtiket == null)
        {
            System.out.println("Error");
            System.exit(0);
        }
        else
            etiket = newEtiket;
    }

    
    // Tarih değişkeni için set metodu
    // Tarih eğişkeni null girilirse
    // Program hata mesajı yazdırır ve sonlanır
    // Hata tespit edilmezse değişkene değer atanır
    public void setTarih(Date newDate)
    {
        if (newDate == null)
        {
            System.out.println("Error");
            System.exit(0);
        }
        else
            
            // Privacy Leak önlenmiştir.
            tarih = new Date(newDate);
    }
    
    
    // Get metotları
    
    
    // Etiket değişkeni için get metodu
    public String getEtiket()
    {
        return etiket;
    }
    
    // Tarih değişkeni için get metodu
    public Date getTarih()
    {
        
        // Privacy Leak önlenmiştir.
        return new Date(tarih);
    }

    @Override
    // toString metodu GeometrikNesne nesnesinin 
    // etiketini ve oluşturulma tarihini döndürür.
    // Tarih değişkeni Date sınfından olduğu için 
    // Date sınıfının toString metodu çağrılır.
    // Bu toString alt sınıfların toString metotları
    // içerisinde de çağrılacaktır.
    public String toString()
    {
        return ("/ "+etiket +" / " +tarih.toString());
    }

}
