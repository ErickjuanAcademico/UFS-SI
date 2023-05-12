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
import javax.imageio.ImageIO;

public class Final_Screen implements ActionListener{

    JLabel venceu;
    
    public Final_Screen(){

        JFrame telaFinal = new JFrame("Quem venceu?");
        telaFinal.setVisible(true);
        telaFinal.setSize(800, 500);
        telaFinal.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        telaFinal.setLocationRelativeTo(null);
        telaFinal.setResizable(false);
        telaFinal.setLayout(null);

        venceu = new JLabel("placeholder!!");
        venceu.setBounds(200, 200, 500, 100);
        venceu.setFont(new Font("Arial", Font.BOLD, 70));
        venceu.setVisible(false);
        telaFinal.add(venceu);


        JButton revelar = new JButton("Mostrar vencedor");
        revelar.setBounds(325, 75, 150, 50);
        telaFinal.add(revelar);

        revelar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //colocar o vencedor no label
        venceu.setVisible(true);
    }
}
