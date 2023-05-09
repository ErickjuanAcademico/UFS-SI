package GUI;

import javax.swing.*;


public class MainScreen{
    public MainScreen(){
        JFrame mainScreen = new JFrame("Login");
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainScreen.setResizable(false);
        mainScreen.setLocationRelativeTo(null);

        ImageIcon background = new ImageIcon("\UrnaEletronica\src\Arquivos\Main_Screen.png");
        JLabel label1 = new JLabel(background);
        label1.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        mainScreen.getContentPane().add(label1);
        mainScreen.setSize(background.getIconWidth(), background.getIconHeight());
    }

    
}
