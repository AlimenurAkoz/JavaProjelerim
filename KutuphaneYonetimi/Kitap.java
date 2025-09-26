package KutuphaneYonetimi;

public class Kitap {
    private String kitapAdi;
    private String yazar;
    private int sayfa;
    private String yayin;
    private String yorum;

    public Kitap(String kitapAdi, String yazar, int sayfa, String yayin) {
        this.kitapAdi = kitapAdi;
        this.yazar = yazar;
        this.sayfa = sayfa;
        this.yayin = yayin;
        this.yorum = "";
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }
    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }
    public String getYazar() {
        return yazar;
    }
    public void setYazar(String yazar) {
        this.yazar = yazar;
    }
    public String getYayin() {
        return yayin;
    }
    public void setYayin(String yayin) {
        this.yayin = yayin;
    }
    public int getSayfa() {
        return sayfa;
    }
    public void setSayfa(int sayfa) {
        this.sayfa = sayfa;
    }

}
