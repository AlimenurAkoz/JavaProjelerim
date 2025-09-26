package KutuphaneYonetimi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kitaplik {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Kitap> kitaplar;
    public Kitaplik(Kitap[] kitaplar) {
        this.kitaplar = new ArrayList<>(Arrays.asList(kitaplar));
    }
    public int getKitapSayisi() {
        return kitaplar.size();
    }
    public int getSayfaSayisi(){
        int toplam = 0;
        for (int i = 0; i < kitaplar.size(); i++){
            toplam += kitaplar.get(i).getSayfa();
        }
        return toplam;
    }

    public void kitapEkle(Kitap kitap){
        System.out.print("Kitap adı: ");
        String kitapAdi = scanner.nextLine();

        System.out.print("Yazar adı: ");
        String yazar = scanner.nextLine();

        System.out.print("Sayfa Sayısı: ");
        int sayfa = scanner.nextInt();

        System.out.print("Yayınevi: ");
        String yayin = scanner.nextLine();

        Kitap kitap1 = new Kitap(kitapAdi, yazar, sayfa, yayin);
        kitapEkle(kitap);

        System.out.println("Kitap başarıyla eklendi: " + kitap1.getKitapAdi());
    }

    public void kitapSil(int kitap){
        kitaplar.remove(kitap);
        System.out.println("Kitap başarıyla silindi: " + kitap);
    }
    public Kitap get(int index) {
        return kitaplar.get(index);
    }

    public void kitapGuncelle(int index, Kitap yeniKitap) {
        if (index >= 0 && index < kitaplar.size()) {
            kitaplar.set(index, yeniKitap);
            System.out.println("Kitap başarıyla güncellendi: " + yeniKitap.getKitapAdi());
        } else {
            System.out.println("Geçersiz indeks!");
        }
    }
}
