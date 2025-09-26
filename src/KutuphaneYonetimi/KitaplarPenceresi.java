package KutuphaneYonetimi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KitaplarPenceresi extends JFrame{
    private JPanel kitaplarPenceresi;
    private JLabel ad;
    private JLabel yazar;
    private JLabel sayfa;
    private JLabel yayin;
    private JTextField textField1;
    private JLabel yorum;
    private JButton kaydet;
    private JButton sil;

    private Kitap kitap;
    private Kitaplik kitaplik;
    private Screen anaEkran;
    private int kitapIndex;
    public KitaplarPenceresi(Kitap kitap, int kitapIndex, Kitaplik kitaplik, Screen anaEkran) {
        this.kitap = kitap;
        this.kitapIndex = kitapIndex;
        this.kitaplik = kitaplik;
        this.anaEkran = anaEkran;

        initializeComponents();
        setupUI();
        setupEventListeners();

        setTitle("Kitap Detayları");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(anaEkran);
        setVisible(true);
    }

    private void initializeComponents() {
        kitaplarPenceresi = new JPanel();
        kitaplarPenceresi.setLayout(new GridLayout(6, 2, 10, 10));

        ad = new JLabel("Kitap Adı:");
        yazar = new JLabel("Yazar:");
        sayfa = new JLabel("Sayfa Sayısı:");
        yayin = new JLabel("Yayınevi:");
        yorum = new JLabel("Yorum:");

        textField1 = new JTextField(kitap.getYorum());

        kaydet = new JButton("Kaydet");
        sil = new JButton("Sil");

        // Kitap bilgilerini label'lara yerleştir
        JLabel adDeger = new JLabel(kitap.getKitapAdi());
        JLabel yazarDeger = new JLabel(kitap.getYazar());
        JLabel sayfaDeger = new JLabel(String.valueOf(kitap.getSayfa()));
        JLabel yayinDeger = new JLabel(kitap.getYayin());

        // Bileşenleri panele ekle
        kitaplarPenceresi.add(ad);
        kitaplarPenceresi.add(adDeger);
        kitaplarPenceresi.add(yazar);
        kitaplarPenceresi.add(yazarDeger);
        kitaplarPenceresi.add(sayfa);
        kitaplarPenceresi.add(sayfaDeger);
        kitaplarPenceresi.add(yayin);
        kitaplarPenceresi.add(yayinDeger);
        kitaplarPenceresi.add(yorum);
        kitaplarPenceresi.add(textField1);
        kitaplarPenceresi.add(kaydet);
        kitaplarPenceresi.add(sil);
        add(kitaplarPenceresi);
    }

    private void setupUI() {
        // Stil ayarları
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        ad.setFont(labelFont);
        yazar.setFont(labelFont);
        sayfa.setFont(labelFont);
        yayin.setFont(labelFont);
        yorum.setFont(labelFont);

        // Buton renkleri
        kaydet.setBackground(new Color(70, 130, 180));
        kaydet.setForeground(Color.WHITE);
        sil.setBackground(new Color(220, 20, 60));
        sil.setForeground(Color.WHITE);

        // TextField ayarları
        textField1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    //buton işlevleri
    private void setupEventListeners() {
        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yorumKaydet();
            }
        });

        sil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kitapSil();
            }
        });
    }

    private void yorumKaydet() {
        // TextField'deki yorumu kitaba kaydet
        kitap.setYorum(textField1.getText());

        // Kitaplıkta kitabı güncelle (sadece yorumu değişmiş olacak)
        kitaplik.kitapGuncelle(kitapIndex, kitap);

        JOptionPane.showMessageDialog(this, "Yorum kaydedildi!");
        dispose(); // pencereyi kapat
        anaEkran.anaEkraniGuncelle(); // Ana ekranı güncelle
    }

    private void kitapSil() {
        int response = JOptionPane.showConfirmDialog(this,
                "'" + kitap.getKitapAdi() + "' adlı kitabı silmek istediğinize emin misiniz?",
                "Kitap Sil", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            kitaplik.kitapSil(kitapIndex);
            JOptionPane.showMessageDialog(this, "Kitap silindi!");
            dispose();
            anaEkran.anaEkraniGuncelle();
        }
    }
    //yorumu kaydetmek için
    public void dispose(){
        kitap.setYorum(textField1.getText());
        super.dispose();
    }
    // Yorumu almak için getter metodu
    public String getYorum() {
        return textField1.getText();
    }

    // Yorumu ayarlamak için setter metodu
    public void setYorum(String yorumMetni) {
        textField1.setText(yorumMetni);
    }
}
