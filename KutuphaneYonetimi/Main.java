package KutuphaneYonetimi;

public class Main {
    public static void main(String[] args) {
        Kitap[] kitaplar = {
                new Kitap("Ruh Adam", "H.N.Atsız", 308,"Ötüken"),
                new Kitap("Kök Tengri'nin Çocukları", "Ahmet Taşağıl",368,"Bilge Kültür")
        };

        Kitaplik kitaplik = new Kitaplik(kitaplar);
        Screen screen = new Screen(kitaplik);
    }
}
