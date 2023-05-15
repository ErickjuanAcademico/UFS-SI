import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.imageio.ImageIO;

public class Final_Screen extends JFrame{

    Eleicao eleicao = new Eleicao();
    static JFrame finalScreen;

    
    public Final_Screen(){
        BufferedImage imagemVencedor = null;

        try {
            imagemVencedor = ImageIO.read(new File(eleicao.revelarVencedor()));
        }
        catch (IOException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eleição Empatada", "Confirmaçao", JOptionPane.ERROR_MESSAGE, null);
        }
        JLabel label = new JLabel();

        finalScreen = new JFrame("Resultado");
        finalScreen.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        finalScreen.setSize(1280,720);
        finalScreen.setResizable(false);
        finalScreen.setLocationRelativeTo(null);

        Image scaledImagemVencedor = imagemVencedor.getScaledInstance(finalScreen.getWidth(), finalScreen.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(scaledImagemVencedor);
        label.setIcon(imageIcon);

        finalScreen.setVisible(true);
        finalScreen.add(label);


           
    }
}
