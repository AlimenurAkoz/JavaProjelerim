package HesapMakinesi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tasarim extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonArti;
    private JButton buttonEksi;
    private JButton buttonCarpi;
    private JButton buttonNokta;
    private JButton button0;
    private JButton buttonDel;
    private JButton buttonBolme;
    private JButton buttonEsit;
    private JButton buttonC;
    private JLabel Ekran;
    private JPanel Panel;
    private boolean hataDurumu = false;
    private boolean sonucGosterimi = false;

    private double ilkSayi = 0; // Hafızadaki sayı
    private String islem = "";   // Yapılacak işlem

    public Tasarim() {
        setTitle("Hesap Makinesi");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//çarpıya basınca kapanır
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x, y);//ekranı ortaladı
        setContentPane(Panel);//tuşların ekranda gözükmesini sağlar-> JPanel' Panel ismini vermiştim
        setVisible(true);//ekranın gözükmesini sağlar

        //0 Butonu
        button0.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("0");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("0");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "0");
                }
            }
        });
        //1 Butonu
        button1.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("1");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("1");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "1");
                }
            }
        });
        //2 Butonu
        button2.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("2");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("2");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "2");
                }
            }
        });
        //3 Butonu
        button3.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("3");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("3");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "3");
                }
            }
        });
        //4 Butonu
        button4.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("4");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("4");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "4");
                }
            }
        });
        //5 Butonu
        button5.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("5");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("5");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "5");
                }
            }
        });
        //6 Butonu
        button6.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("6");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("6");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "6");
                }
            }
        });
        //7 Butonu
        button7.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("7");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("7");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "7");
                }
            }
        });
        //8 Butonu
        button8.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("8");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("8");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "8");
                }
            }
        });
        //9 Butonu
        button9.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("9");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                if (sayi.equals("0") || hataDurumu) {
                    Ekran.setText("9");
                    hataDurumu = false;
                } else {
                    Ekran.setText(sayi + "9");
                }
            }
        });
        //= butonu
        buttonEsit.addActionListener(e -> {
            try {
                double ikinciSayi = Double.parseDouble(Ekran.getText());
                double sonuc = 0;

                if (islem.equals("+")) {
                    sonuc = ilkSayi + ikinciSayi;
                }
                if (islem.equals("-")) {
                    sonuc = ilkSayi - ikinciSayi;
                }
                if (islem.equals("x")) {
                    sonuc = ilkSayi * ikinciSayi;
                }
                if (islem.equals("÷")) {
                    if (ikinciSayi == 0) {
                        Ekran.setText("Hata!");
                        hataDurumu = true;
                        sonucGosterimi = false;
                        return;
                    }
                    sonuc = ilkSayi / ikinciSayi;
                }

                Ekran.setText(String.valueOf(sonuc));
                hataDurumu = false;
                sonucGosterimi = true;
            } catch (NumberFormatException ex) {
                Ekran.setText("Hata!");
                hataDurumu = true;
            }
        });
        //+butonu
        buttonArti.addActionListener(e -> {
            try {
                ilkSayi = Double.parseDouble(Ekran.getText()); // Ekrandaki sayıyı al
                islem = "+"; // İşlem türünü kaydet
                Ekran.setText("0"); // Ekranı temizle, kullanıcı ikinci sayıyı girecek
                hataDurumu = false;
                sonucGosterimi = false;
            } catch (NumberFormatException ex) {//GEÇERSİZ SAYI
                Ekran.setText("Hata!");
                /*Double.parseDouble("123abc") // Hata! Sayı olmayan karakterler içeriyor
Double.parseDouble("12.34.56") // Hata! Birden fazla nokta var
Double.parseDouble("") // Hata! Boş string*/
                hataDurumu = true;
                sonucGosterimi = false;
            }
        });
        //-butonu
        buttonEksi.addActionListener(e -> {
            try {
                ilkSayi = Double.parseDouble(Ekran.getText());
                islem = "-";
                Ekran.setText("0");
                hataDurumu = false;
                sonucGosterimi = false;
            } catch (NumberFormatException ex) {
                Ekran.setText("Hata!");
                hataDurumu = true;
                sonucGosterimi = false;
            }
        });
        //x butonu
        buttonCarpi.addActionListener(e -> {
            try {
                ilkSayi = Double.parseDouble(Ekran.getText());
                islem = "x";
                Ekran.setText("0");
                hataDurumu = false;
                sonucGosterimi = false;
            } catch (NumberFormatException ex) {
                Ekran.setText("Hata!");
                hataDurumu = true;
                sonucGosterimi = false;
            }
        });
        //÷ butonu
        buttonBolme.addActionListener(e -> {
            try {
                ilkSayi = Double.parseDouble(Ekran.getText());
                islem = "÷";
                Ekran.setText("0");
                hataDurumu = false;
                sonucGosterimi = false;
            } catch (NumberFormatException ex) {
                Ekran.setText("Hata!");
                hataDurumu = true;
                sonucGosterimi = false;
            }
        });
        //C butonu
        buttonC.addActionListener(e -> {
            Ekran.setText("0");
            hataDurumu = false;
            sonucGosterimi = false;
        });

        //Del butonu
        buttonDel.addActionListener(e -> {
            hataDurumuTemizle();
            if (sonucGosterimi) {
                Ekran.setText("0");
                sonucGosterimi = false;
            } else {
                String text = Ekran.getText();
                if (text.length() > 1) {
                    // sondaki karakteri sil
                    text = text.substring(0, text.length() - 1);
                    Ekran.setText(text);
                } else {
                    // Tek karakter varsa, sıfırla
                    Ekran.setText("0");
                }
            }
        });
        //. butonu
        buttonNokta.addActionListener(e -> {
            if (sonucGosterimi) {
                Ekran.setText("0.");
                sonucGosterimi = false;
            } else {
                String sayi = Ekran.getText();
                hataDurumuTemizle();
                Ekran.setText(sayi + ".");
            }
        });

    }

    public void hataDurumuTemizle() {
        if (hataDurumu) {
            // Hata varsa önce ekranı temizle
            Ekran.setText("0");
            hataDurumu = false;
        }
    }
}
