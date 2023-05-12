import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.imageio.ImageIO;



public class Main_Screen implements ActionListener{
    JTextField cadastro;
    JTextField senha;
    static JFrame mainScreen;


    public static JFrame getMainScreen() {
        return mainScreen;
    }
    public Main_Screen(){
        BufferedImage background = null;

        try {
            background = ImageIO.read(new File("UrnaEletronica\\src\\GUI\\Arquivos\\Main_Screen.png"));
        }
        catch (IOException erro) {
            erro.printStackTrace();
        }
        JLabel label = new JLabel();

        mainScreen = new JFrame("Login");
        mainScreen.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        JButton finalizar = new JButton("Finalizar");
        finalizar.setBounds(950, 350, 100, 30);
        label.add(finalizar);

        JButton resetar = new JButton("recomeçar");
        resetar.setBounds(150, 350, 100, 30);
        label.add(resetar);


        cadastro = new JTextField();
        cadastro.setBounds(430, 442, 420, 45);

        label.add(cadastro);

        senha = new JTextField();
        senha.setBounds(900, 315, 200, 30);
        senha.setEditable(true);
        senha.setVisible(true);

        label.add(senha);

        finalizar.addActionListener(this::mostrar);
        confirmar.addActionListener(this);
        resetar.addActionListener(this::recomeçar);

    }
    private String frase;

    public void recomeçar(ActionEvent actionEvent) {

        try {
            //Limpa o arquivo de Votos.
            
            FileWriter clearVotos = new FileWriter("UrnaEletronica\\src\\Votos.txt", false);
            clearVotos.write("");
            clearVotos.close();
            
            //Reseta todas as chaves de voto para false.
            
            BufferedReader readerEleitores = new BufferedReader(new FileReader("UrnaEletronica\\src\\Eleitores.txt"));
            StringBuilder linesEleitores = new StringBuilder();
            String line;
            while ((line = readerEleitores.readLine()) != null) {
                String[] campos = line.split(",");
                String novaLinha = campos[0] + "," + campos[1] + "," + campos[2] + "," + "false";
                line = novaLinha;
                linesEleitores.append(line).append("\n");
            }
            readerEleitores.close();
            FileWriter writerEleitores = new FileWriter("UrnaEletronica\\src\\Eleitores.txt");
            writerEleitores.write(linesEleitores.toString());
            writerEleitores.close();
            
            //Reseta a quantidade de votos dos vilões.
            
            BufferedReader readerViloes = new BufferedReader(new FileReader("UrnaEletronica\\src\\Viloes.txt"));
            StringBuilder linesViloes = new StringBuilder();
            String lineViloes;
            while ((line = readerViloes.readLine()) != null) {
                String[] campos = line.split(",");
                String novaLinha = campos[0] + "," + campos[1] + "," + campos[2] + "," + "0";
                line = novaLinha;
                linesViloes.append(line).append("\n");
            }
            readerViloes.close();
            FileWriter writerViloes = new FileWriter("UrnaEletronica\\src\\Viloes.txt");
            writerViloes.write(linesViloes.toString());
            writerViloes.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrar(ActionEvent actionEvent){
        if(senha.getText().equals("123")){
            //chamar tela de vencedor
            mainScreen.dispose();
            Final_Screen finalScreen = new Final_Screen();
        } else {
            JOptionPane.showMessageDialog(null, "Senha Errada!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    private boolean codigoExiste(String codigo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Eleitores.txt"));
            String linha = reader.readLine();
            while (linha != null) {
                if (linha.split(",")[1].equals(codigo)) {
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
    
        if (codigoExiste(cpf)) {
            try {
                Eleitor eleitor = new Eleitor("getNome", cpf);
                if (eleitor.chaveJaUtilizada()) {
                    JOptionPane.showMessageDialog(null, "Você já votou!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
                } else {
                    // Eleitor ainda pode votar
                    mainScreen.dispose();
                    // chama a tela de votação aqui
                    Vote_Screen voteScreen = new Vote_Screen(cpf);
                       
                }
            } catch (NoSuchAlgorithmException | IOException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao verificar a chave de voto!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CPF não cadastrado!", "Verificação", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
