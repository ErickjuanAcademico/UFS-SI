package GUI;

import javax.swing.*;
import java.awt.*;


public class MainScreen extends JFrame{
    public MainScreen(){
        setTitle("Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(1280, 720);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        ImageIcon background = new ImageIcon(getClass().getResource("\\UrnaEletronica\\src\\GUI\\Main_Screen.png"));
        Image image = background.getImage();
        Image scaledImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel label1 = new JLabel(scaledImageIcon);
        label1.setBounds(0, 0, 800, 600);
        panel.add(label1);
        setContentPane(panel);
        
    }

    
}
