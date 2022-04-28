package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int kapasite = 40; // sınıf kapasitesi
        int[] notlar = new int[kapasite];

        for (int i = 0; i < kapasite; i++) {
            System.out.printf("%d. not: ",i + 1);
            notlar[i] = scanner.nextInt(); // not girdisi
        }

        int[] frekans = new int[11]; // 11 tane 00-09,10-20 var

        for (int j = 0; j < notlar.length; j++) {
            int not = notlar[j]; // notları aldık

            frekans[not/10]++; // not/10 dan kalana göre indis artar
        }

        int maxFrekans = 0;

        // frekansta max degeri ariyoruz
        for (int i = 0; i < frekans.length; i++) {
            if (frekans[i] > maxFrekans) {
                maxFrekans = frekans[i];
            }
        }

        // notlar yukarıdan asagı inicek
        for (int seviye = maxFrekans; seviye > 0; seviye--) {

            // her katta soldan sağa gitmek için
            for (int i = 0; i < frekans.length; i++) {

                // seviye ile frekans karsılastıracagız
                if (seviye <= frekans[i]) {
                    System.out.print("   *   ");
                }
                else {
                    //yukaridaki alan kadar bosluk birak
                    System.out.print("       ");
                }
            }
            // bir sıra bittince alt sıra gec
            System.out.println();
        }

        // cizgileri ekledik
        for (int i = 0; i < frekans.length; i++) {
            System.out.print(" ----- "); 
        }
        System.out.println(); // cizgiden sonra alt satıra gec

        // frekansı 10 ile çarpıp not aralıgı bulunur
        for (int i = 0; i < frekans.length - 1; i++) { // frekans.lenght - 1 90-99 kadar yazar 100 kendimiz eklicez
            System.out.printf(" %02d-%02d ",i*10,(i + 1) * 10 - 1); // 00 yazmak için %02
        }

        System.out.println("  100  ");
    }
}
