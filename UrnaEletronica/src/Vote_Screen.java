

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;



public class Vote_Screen implements ActionListener {
    JTextField codigo;
    private String codigoEleitor;
    public Vote_Screen(String cpf){
        this.codigoEleitor = cpf;

        JFrame telaVotos = new JFrame("Votar");
        telaVotos.setVisible(true);
        telaVotos.setSize(800, 500);
        telaVotos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        telaVotos.setLocationRelativeTo(null);
        telaVotos.setResizable(false);
        telaVotos.setLayout(null);

        JButton votar = new JButton("Vote!");
        votar.setBounds(325, 380, 150, 50);
        telaVotos.add(votar);

        JButton voto1 = new JButton("Darth Vader");
        voto1.setBounds(150, 100, 150, 50);
        telaVotos.add(voto1);

        JButton voto2 = new JButton("Dr. Octopus");
        voto2.setBounds(325, 100, 150, 50);
        telaVotos.add(voto2);

        JButton voto3 = new JButton("Coringa");
        voto3.setBounds(500, 100, 150, 50);
        telaVotos.add(voto3);

        JButton voto4 = new JButton("Thanos");
        voto4.setBounds(150, 200, 150, 50);
        telaVotos.add(voto4);

        JButton voto5 = new JButton("Voldemort");
        voto5.setBounds(325, 200, 150, 50);
        telaVotos.add(voto5);

        JButton voto6 = new JButton("Satanas");
        voto6.setBounds(500, 200, 150, 50);
        telaVotos.add(voto6);

        votar.addActionListener(this);
        voto1.addActionListener(this::teste1);
        voto2.addActionListener(this::teste2);
        voto3.addActionListener(this::teste3);
        voto4.addActionListener(this::teste4);
        voto5.addActionListener(this::teste5);
        voto6.addActionListener(this::teste6);

        codigo = new JTextField();
        codigo.setBounds(310, 340, 180, 30);
        codigo.setEditable(false);
        telaVotos.add(codigo);

    }
    public String getCodigoEleitor() {
        return codigoEleitor;
    }
    private void teste1(ActionEvent actionEvent){
        codigo.setText("666");
    }
    private void teste2(ActionEvent actionEvent){
        codigo.setText("777");
    }
    private void teste3(ActionEvent actionEvent){
        codigo.setText("888");
    }
    private void teste4(ActionEvent actionEvent){
        codigo.setText("999");
    }
    private void teste5(ActionEvent actionEvent){
        codigo.setText("111");
    }
    private void teste6(ActionEvent actionEvent){
        codigo.setText("333");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            Vilao vilao = new Vilao("getNome", codigo.getText());
            Eleitor eleitor = new Eleitor("getNome",getCodigoEleitor());
            vilao.atualizarVoto();
            JOptionPane.showMessageDialog(null, "Voto computado!", "Confirmaçao", JOptionPane.INFORMATION_MESSAGE, null);
            JFrame telaVotos = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());
            eleitor.atualizarChaveDeVoto();
            telaVotos.dispose();
            Main_Screen.getMainScreen().setVisible(true);
        } catch (NoSuchAlgorithmException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
                }

    }

