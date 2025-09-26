package ToDoList;

import javax.swing.*;
import java.awt.*;

public class List extends JFrame{
    private JPanel Panel;
    private JTextField gorevEkle;
    private JButton listele;
    private JButton ekleButton;

    List() {
        setTitle("To-Do List");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x, y);
        setContentPane(Panel);
        setVisible(true);

        ekleButton.addActionListener(e -> {
            String text = gorevEkle.getText();
                if (text.isEmpty()){
                    JOptionPane.showMessageDialog(//uyarı ekranı açar
                          null,//ortada açılmasını sağlar
                          "Görev Girilmedi!"
                    );
                }
        });
    }
}
