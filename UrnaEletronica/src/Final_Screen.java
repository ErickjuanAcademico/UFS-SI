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

    JLabel venceu1;
    JLabel venceu2;
    JLabel venceu3;
    JLabel venceu4;
    JLabel venceu5;
    JLabel venceu6;
    JButton mostrar;
    
    public Final_Screen(){
        BufferedImage imagem1 = null;
        BufferedImage imagem2 = null;
        BufferedImage imagem3 = null;
        BufferedImage imagem4 = null;
        BufferedImage imagem5 = null;
        BufferedImage imagem6 = null;

        try {
            imagem1 = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Darth_vader.jpg"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        try {
            imagem2 = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Coringa.jpg"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        try {
            imagem3 = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Dr_octopus.jpg"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        try {
            imagem4 = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Voldemort.jpg"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        try {
            imagem5 = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Thano.jpg"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        try {
            imagem6 = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Satanas.jpg"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }

        JFrame telaFinal = new JFrame("Quem venceu?");
        
        telaFinal.setSize(1280, 720);
        telaFinal.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        telaFinal.setLocationRelativeTo(null);
        telaFinal.setResizable(false);
        telaFinal.setLayout(null);
        

        Image vader = imagem1.getScaledInstance(telaFinal.getWidth(), telaFinal.getHeight(), 1);
        Image joker = imagem2.getScaledInstance(telaFinal.getWidth(), telaFinal.getHeight(), 1);
        Image drOctopus = imagem3.getScaledInstance(telaFinal.getWidth(), telaFinal.getHeight(), 1);
        Image voldemort = imagem4.getScaledInstance(telaFinal.getWidth(), telaFinal.getHeight(), 1);
        Image thano = imagem5.getScaledInstance(telaFinal.getWidth(), telaFinal.getHeight(), 1);
        Image satan = imagem6.getScaledInstance(telaFinal.getWidth(), telaFinal.getHeight(), 1);

        venceu1 = new JLabel();
        venceu2 = new JLabel();
        venceu3 = new JLabel();
        venceu4 = new JLabel();
        venceu5 = new JLabel();
        venceu6 = new JLabel();

        ImageIcon vencedor1 = new ImageIcon(vader);
        venceu1.setBounds(telaFinal.getX()/2 - 20, telaFinal.getY()/2, 1280, 720);
        venceu1.setIcon(vencedor1);
        venceu1.setVisible(false);

        ImageIcon vencedor2 = new ImageIcon(joker);
        venceu2.setBounds(telaFinal.getX()/2 - 20, telaFinal.getY()/2, 1280, 720);
        venceu2.setIcon(vencedor2);
        venceu2.setVisible(false);

        ImageIcon vencedor3 = new ImageIcon(drOctopus);
        venceu3.setBounds(telaFinal.getX()/2 - 20, telaFinal.getY()/2, 1280, 720);
        venceu3.setIcon(vencedor3);
        venceu3.setVisible(false);

        ImageIcon vencedor4 = new ImageIcon(voldemort);
        venceu4.setBounds(telaFinal.getX()/2 - 20, telaFinal.getY()/2, 1280, 720);
        venceu4.setIcon(vencedor4);
        venceu4.setVisible(false);

        ImageIcon vencedor5 = new ImageIcon(thano);
        venceu5.setBounds(telaFinal.getX()/2 - 20, telaFinal.getY()/2, 1280, 720);
        venceu5.setIcon(vencedor5);
        venceu5.setVisible(false);

        ImageIcon vencedor6 = new ImageIcon(satan);
        venceu6.setBounds(telaFinal.getX()/2 - 20, telaFinal.getY()/2, 1280, 720);
        venceu6.setIcon(vencedor6);
        venceu6.setVisible(false);

        mostrar = new JButton("Mostrar Vencedor");
        mostrar.setBounds(540, 300, 200, 50);
        mostrar.setVisible(true);

        
        telaFinal.setVisible(true);
        telaFinal.add(mostrar);
        telaFinal.add(venceu1);
        telaFinal.add(venceu2);
        telaFinal.add(venceu3);
        telaFinal.add(venceu4);
        telaFinal.add(venceu5);
        telaFinal.add(venceu6);
        
        mostrar.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        venceu6.setVisible(true);
        mostrar.setVisible(false);
        
    }
}
