

<<<<<<< HEAD
public class Vote_Screen {
    
=======
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vote_Screen implements ActionListener {
    JTextField codigo;
    public Vote_Screen(){
        JFrame telaVotos = new JFrame("Votar");
        telaVotos.setVisible(true);
        telaVotos.setSize(800, 500);
        telaVotos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        votar.addActionListener(this);
        voto1.addActionListener(this::teste1);
        voto2.addActionListener(this::teste2);
        voto3.addActionListener(this::teste3);

        codigo = new JTextField();
        codigo.setBounds(310, 340, 180, 30);
        telaVotos.add(codigo);


    }
    private void teste1(ActionEvent actionEvent){
        codigo.setText("666");
    }
    private void teste2(ActionEvent actionEvent){
        codigo.setText("999");
    }
    private void teste3(ActionEvent actionEvent){
        codigo.setText("777");
    }


    @Override
    public void actionPerformed(ActionEvent e){

    }
>>>>>>> 58e546398b3ec3a453c40ecaadd8317d41788424
}
