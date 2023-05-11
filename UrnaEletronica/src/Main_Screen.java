

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



public class Main_Screen implements ActionListener{
    JTextField cadastro;
    public Main_Screen(){
        BufferedImage background = null;

        try {
            background = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Main_Screen.png"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        JLabel label = new JLabel();

        JFrame mainScreen = new JFrame("Login");
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setSize(1280,720);
        mainScreen.setResizable(false);
        mainScreen.setLocationRelativeTo(null);

        Image scaledBackgroundImage = background.getScaledInstance(mainScreen.getWidth(), mainScreen.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(scaledBackgroundImage);
        label.setIcon(imageIcon);

        mainScreen.setVisible(true);
        mainScreen.add(label);
        
        
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(535, 542, 207, 60);
        label.add(confirmar);

        confirmar.addActionListener(this);
        
        cadastro = new JTextField();
        cadastro.setBounds(430, 442, 420, 45);

        label.add(cadastro);

    }
    private String frase;
    
    private boolean cpfExiste(String cpf) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Eleitores.txt"));
            String linha = reader.readLine();
            while (linha != null) {
                if (linha.split(",")[1].equals(cpf)) {
                    reader.close();
                    return true;
                }
                linha = reader.readLine();
            }
            reader.close();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        String cpf = cadastro.getText();
    
        if (cpfExiste(cpf)) {
            try {
                Eleitor eleitor = new Eleitor("getNome", cpf);
                if (eleitor.chaveJaUtilizada()) {
                    JOptionPane.showMessageDialog(null, "Você já votou!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
                } else {
                    // Eleitor ainda pode votar
                    // chamar a tela de votação aqui
                    eleitor.atualizarChaveDeVoto();
                }
            } catch (NoSuchAlgorithmException | IOException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao verificar a chave de voto!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CPF não cadastrado!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
