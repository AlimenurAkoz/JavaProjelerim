package KutuphaneYonetimi;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame{
    private Kitaplik kitaplik;
    private JPanel wrapper;
    private JLabel kitapSayisi;
    private JLabel sayfalar;
    private JButton btn_kitaplarim;

    public Screen(Kitaplik kitaplik){
        this.kitaplik = kitaplik;
        wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        kitapSayisi = new JLabel("Toplam Kitap Sayısı: " + kitaplik.getKitapSayisi()); // JLabel oluştur
        // Kitap sayısını al ve yazdır
        kitapSayisi.setFont(labelFont);
        kitapSayisi.setAlignmentX(Component.CENTER_ALIGNMENT);

        sayfalar = new JLabel("Toplam Sayfa Sayısı: "+kitaplik.getSayfaSayisi());
        sayfalar.setFont(labelFont);
        sayfalar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn_kitaplarim = new JButton("Kitaplarım");
        btn_kitaplarim.setAlignmentX(Component.CENTER_ALIGNMENT);

        wrapper.add(Box.createVerticalStrut(30));//30 piksel boşluk bırakır
        wrapper.add(kitapSayisi);
        wrapper.add(Box.createVerticalStrut(15));
        wrapper.add(sayfalar);
        wrapper.add(Box.createVerticalStrut(30));
        wrapper.add(btn_kitaplarim);
        this.add(wrapper);

        setSize(350,350);
        setTitle("Benim Kütüphanem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width)/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height)/2;
        setLocation(x,y);//otomatik olarak ekranın ortasından başlatır
        setVisible(true);

        wrapper.add(btn_kitaplarim);
        btn_kitaplarim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kitaplariGoster();
            }
        });
    }
    private void kitaplariGoster() {
        JFrame kitaplarFrame = new JFrame("Kitaplarım");
        kitaplarFrame.setSize(600, 400);
        kitaplarFrame.setLayout(new BorderLayout());
        kitaplarFrame.setLocationRelativeTo(this);

        // Tablo oluştur
        String[] kolonlar = {"Kitap Adı", "Yazar", "Sayfa Sayısı", "Yayınevi"};
        String[][] veri = new String[kitaplik.getKitapSayisi()][4];

        for (int i = 0; i < kitaplik.getKitapSayisi(); i++) {
            Kitap kitap = kitaplik.get(i);
            veri[i][0] = kitap.getKitapAdi();
            veri[i][1] = kitap.getYazar();
            veri[i][2] = String.valueOf(kitap.getSayfa());
            veri[i][3] = kitap.getYayin();
        }

        JTable table = new JTable(veri, kolonlar);
        JScrollPane scrollPane = new JScrollPane(table);

        // Buton paneli
        JPanel buttonPanel = createButtonPanel(table, kitaplarFrame);

        kitaplarFrame.add(scrollPane, BorderLayout.CENTER);
        kitaplarFrame.add(buttonPanel, BorderLayout.SOUTH);
        kitaplarFrame.setVisible(true);
    }


    private JPanel createButtonPanel(JTable table, JFrame parentFrame) {
        JPanel buttonPanel = new JPanel();
        JButton detayGosterBtn = new JButton("Detayları Göster");
        JButton silBtn = new JButton("Kitabı Sil");
        JButton duzenleBtn = new JButton("Kitabı Düzenle");
        JButton yeniKitapBtn = new JButton("Yeni Kitap Ekle");

        buttonPanel.add(detayGosterBtn);
        buttonPanel.add(silBtn);
        buttonPanel.add(duzenleBtn);
        buttonPanel.add(yeniKitapBtn);

        // Butonları başlangıçta devre dışı bırak
        detayGosterBtn.setEnabled(false);
        silBtn.setEnabled(false);
        duzenleBtn.setEnabled(false);

        // Tablo seçim dinleyicisi
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    detayGosterBtn.setEnabled(true);
                    silBtn.setEnabled(true);
                    duzenleBtn.setEnabled(true);
                } else {
                    detayGosterBtn.setEnabled(false);
                    silBtn.setEnabled(false);
                    duzenleBtn.setEnabled(false);
                }
            }
        });

        // Buton işlevleri
        detayGosterBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                kitapDetaylariGoster(selectedRow);
            }
        });

        silBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                kitapSil(selectedRow, parentFrame);
            }
        });

        duzenleBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                kitapDuzenle(selectedRow, parentFrame);
            }
        });

        yeniKitapBtn.addActionListener(e -> {
            yeniKitapEkle(parentFrame);
        });

        return buttonPanel;
    }


    private void kitapDetaylariGoster(int index) {
        Kitap kitap = kitaplik.get(index);
        new KitaplarPenceresi(kitap, index, kitaplik, this);
    }

    private void kitapSil(int index, JFrame parentFrame) {
        Kitap kitap = kitaplik.get(index);
        int response = JOptionPane.showConfirmDialog(this,
                "'" + kitap.getKitapAdi() + "' adlı kitabı silmek istediğinize emin misiniz?",
                "Kitap Sil", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            kitaplik.kitapSil(index);
            JOptionPane.showMessageDialog(this, "Kitap silindi!");
            parentFrame.dispose();
            kitaplariGoster(); // Listeyi yenile
            anaEkraniGuncelle(); // Ana ekranı güncelle
        }
    }

    private void kitapDuzenle(int index, JFrame parentFrame) {
        Kitap kitap = kitaplik.get(index);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JTextField adField = new JTextField(kitap.getKitapAdi());
        JTextField yazarField = new JTextField(kitap.getYazar());
        JTextField sayfaField = new JTextField(String.valueOf(kitap.getSayfa()));
        JTextField yayinField = new JTextField(kitap.getYayin());

        panel.add(new JLabel("Kitap Adı:"));
        panel.add(adField);
        panel.add(new JLabel("Yazar:"));
        panel.add(yazarField);
        panel.add(new JLabel("Sayfa Sayısı:"));
        panel.add(sayfaField);
        panel.add(new JLabel("Yayınevi:"));
        panel.add(yayinField);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Kitap Düzenle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Kitap yeniKitap = new Kitap(
                        adField.getText(),
                        yazarField.getText(),
                        Integer.parseInt(sayfaField.getText()),
                        yayinField.getText()
                );

                kitaplik.kitapGuncelle(index, yeniKitap);
                JOptionPane.showMessageDialog(this, "Kitap güncellendi!");
                parentFrame.dispose();
                kitaplariGoster(); // Listeyi yenile
                anaEkraniGuncelle(); // Ana ekranı güncelle
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Sayfa sayısı geçerli bir sayı olmalıdır!",
                        "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void yeniKitapEkle(JFrame parentFrame) {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        JTextField adField = new JTextField(15);
        JTextField yazarField = new JTextField(15);
        JTextField sayfaField = new JTextField(15);
        JTextField yayinField = new JTextField(15);
        JTextField yorumField = new JTextField(15);

        panel.add(new JLabel("Kitap Adı:"));
        panel.add(adField);
        panel.add(new JLabel("Yazar:"));
        panel.add(yazarField);
        panel.add(new JLabel("Sayfa Sayısı:"));
        panel.add(sayfaField);
        panel.add(new JLabel("Yayınevi:"));
        panel.add(yayinField);
        panel.add(new JLabel("Yorum:"));
        panel.add(yorumField);

        int result = JOptionPane.showConfirmDialog(parentFrame, panel,
                "Yeni Kitap Ekle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Kitap yeniKitap = new Kitap(
                        adField.getText(),
                        yazarField.getText(),
                        Integer.parseInt(sayfaField.getText()),
                        yayinField.getText()
                );
                yeniKitap.setYorum(yorumField.getText());
                kitaplik.kitapEkle(yeniKitap);
                JOptionPane.showMessageDialog(this, "Yeni kitap eklendi!");
                parentFrame.dispose();
                kitaplariGoster(); // Listeyi yenile
                anaEkraniGuncelle(); // Ana ekranı güncelle
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Sayfa sayısı geçerli bir sayı olmalıdır!",
                        "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void anaEkraniGuncelle() {
        kitapSayisi.setText("Toplam Kitap Sayısı: " + kitaplik.getKitapSayisi());
        sayfalar.setText("Toplam Sayfa Sayısı: " + kitaplik.getSayfaSayisi());
    }
}