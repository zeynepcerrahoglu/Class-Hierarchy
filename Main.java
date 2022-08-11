package com.company;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner fileIn = null;
        File file;
        try {
            file = new File("Input.txt");
            fileIn = new Scanner(new FileInputStream(file)).useLocale(Locale.US);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }


//        File file = new File("Input.txt");
////        try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
////
////            while (lnr.readLine() != null)
////                satirSayisi = lnr.getLineNumber();
////
////        } catch (IOException e) {
////            e.printStackTrace();
//        }

        GeometrikNesne[] anaDizi = new GeometrikNesne[50];

        int sayac = 0;
        int indexIlkDai = 0, indexSonDai = 0;
        int indexIlkDik = 0, indexSonDik = 0;
        int indexIlkSil = 0, indexSonSil = 0;
        boolean ilkDaiBulunduMu = false, ilkDikBulunduMu = false, ilkSilBulunduMu = false;


        while (fileIn.hasNext()) {

            String cisimTipi = fileIn.next();

            if (cisimTipi.equals("daire")) {
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                fileIn.next();
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                anaDizi[sayac] = new Daire(etiket, new Date(gun, ay, yil),
                        yaricap);

                if ((indexIlkDai == 0) && (!ilkDaiBulunduMu)) {
                    indexIlkDai = sayac;
                    ilkDaiBulunduMu = true;
                }

                indexSonDai = sayac;

            } else if (cisimTipi.equals("dikdortgen")) {
                String etiket = fileIn.next();
                double en = fileIn.nextDouble();
                double boy = fileIn.nextDouble();
                fileIn.next();
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                anaDizi[sayac] = new Dikdortgen(etiket, new Date(gun, ay, yil),
                        boy, en);

                if ((indexIlkDik == 0) && (!ilkDikBulunduMu)) {
                    indexIlkDik = sayac;
                    ilkDikBulunduMu = true;
                }

                indexSonDik = sayac;

            } else if (cisimTipi.equals("silindir")) {
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                double uzunluk = fileIn.nextDouble();
                fileIn.next();
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                anaDizi[sayac] = new Silindir(etiket, new Date(gun, ay, yil),
                        yaricap, uzunluk);

                if ((indexIlkSil == 0) && (!ilkSilBulunduMu)) {
                    indexIlkSil = sayac;
                    ilkSilBulunduMu = true;
                }

                indexSonSil = sayac;

            } else
                System.out.println("Yanlış veri girildi.");
            sayac++;

            /*if (fileIn.next().equals("daire"))
            {
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                fileIn.next();
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                anaDizi[sayac] = new Daire(etiket,new Date(gun, ay, yil),
                        yaricap);


            }
            else if(fileIn.next().equals("dikdortgen"))
            {
                String etiket = fileIn.next();
                double boy = fileIn.nextDouble();
                double en = fileIn.nextDouble();
                fileIn.next();
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                anaDizi[sayac] = new Dikdortgen(etiket, new Date(gun, ay, yil),
                        boy, en);

            }
            else
            {
                String etiket = fileIn.next();
                double yaricap = fileIn.nextDouble();
                double uzunluk = fileIn.nextDouble();
                fileIn.next();
                int gun = fileIn.nextInt();
                int ay = fileIn.nextInt();
                int yil = fileIn.nextInt();

                anaDizi[sayac] = new Silindir(etiket, new Date(gun, ay, yil),
                        yaricap, uzunluk);
            }*/
        }
        /*for(int i = 1; i < anaDizi.length; i++)
        {
            if (anaDizi[i].getEtiket().equals("dai3")) {
                anaDizi[sayac] = new Daire((Daire) anaDizi[i]);
                sayac++;
            }
            else if (anaDizi[i].getEtiket().equals("dik2")) {
                anaDizi[sayac] = new Dikdortgen((Dikdortgen) anaDizi[i]);
                sayac++;
            }
            else if (anaDizi[i].getEtiket().equals("sil2")) {
                anaDizi[sayac] = new Silindir((Silindir) anaDizi[i]);
                sayac++;
            }


        }*/
        anaDizi[sayac] = new Daire((Daire) anaDizi[indexSonDai]);
        int indexKopyaDai = sayac;
        //if (anaDizi[indexSonDik] instanceof Dikdortgen)
        anaDizi[sayac + 1] = new Dikdortgen((Dikdortgen) anaDizi[indexSonDik]);
        int indexKopyaDik = sayac + 1;
        anaDizi[sayac + 2] = new Silindir((Silindir) anaDizi[indexSonSil]);
        int indexKopyaSil = sayac + 2;

        sayac += 3;

        double[] hesaplar = new double[9];
        double cevreToplam = 0, alanToplam = 0, hacimToplam = 0;
        int silidirSayi = 0;

        for (GeometrikNesne nesne : anaDizi) {
            if (nesne != null) {

                polymorphicYazdir(nesne);

                double nesneCevre = nesne.cevreHesapla();
                double nesneAlan = nesne.alanHesapla();

                cevreToplam += nesneCevre;
                alanToplam += nesneAlan;

                if ((hesaplar[3] >nesneCevre) || (hesaplar[3] == 0))
                    hesaplar[3] = nesneCevre;

                if (hesaplar[4] <nesneCevre)
                    hesaplar[4] = nesneCevre;

                if ((hesaplar[5] > nesneAlan) || (hesaplar[5] == 0))
                    hesaplar[5] = nesneAlan;

                if (hesaplar[6] < nesneAlan)
                    hesaplar[6] = nesneAlan;

                if (nesne instanceof Silindir) {
                    silidirSayi++;

                    double nesneHacim = ((Silindir) nesne).hacimHesapla();

                    hacimToplam += nesneHacim;

                    if (hesaplar[8] < nesneHacim)
                        hesaplar[8] = nesneHacim;

                    if ((hesaplar[7] > nesneHacim) || (hesaplar[7] == 0))
                        hesaplar[7] = nesneHacim;
                }
            }

        }

        hesaplar[0] = cevreToplam / (sayac);
        hesaplar[1] = alanToplam / (sayac);
        hesaplar[2] = hacimToplam / silidirSayi;

        System.out.println("\n\nKarşılaştırma");
        System.out.print("-------------");
        karsilastir(anaDizi[indexIlkDai], anaDizi[indexKopyaDai]);
        karsilastir(anaDizi[indexKopyaDai], anaDizi[indexSonDai]);
        karsilastir(anaDizi[indexIlkDik], anaDizi[indexKopyaDik]);
        karsilastir(anaDizi[indexKopyaDik], anaDizi[indexSonDik]);
        karsilastir(anaDizi[indexIlkSil], anaDizi[indexKopyaSil]);
        karsilastir(anaDizi[indexKopyaSil], anaDizi[indexSonSil]);

        System.out.println("\nHesaplar isimli tek boyutlu dizinin içindekiler");
        System.out.print("-----------------------------------------------");
        for (double hesap : hesaplar) {
            System.out.printf("\n%.3f", hesap);
        }


    }

    public static void polymorphicYazdir(GeometrikNesne nesne)
    {
        System.out.println("\nNesne: "+ nesne.toString());
        System.out.println("-----");
        System.out.printf("Alan: %.3f ", nesne.alanHesapla());
        System.out.printf("\nÇevre: %.3f ", nesne.cevreHesapla());
        if(nesne.getClass() == Silindir.class)
        {
            Silindir newSilindir = (Silindir) nesne;
            System.out.printf("\nHacim: %.3f", newSilindir.hacimHesapla());
        }
        System.out.println();


    }
    public static void karsilastir(GeometrikNesne nesne1, GeometrikNesne nesne2)
    {
        int sonuc = nesne1.compareTo(nesne2);
        System.out.println("\nMetotdun çağrıldığı nesne: " + nesne1.toString());
        System.out.println("Metotda parametre olarak verilen nesne: " + nesne2.toString());
        System.out.println("Sonuç: " + sonuc);
    }


}
