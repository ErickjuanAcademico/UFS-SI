import Interfaces.iReceberVoto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Vilao extends Pessoa implements Serializable, iReceberVoto {
    private String nome;
    private int votos;
    private String hash;

    public Vilao(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String gerarHash(String texto) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(texto.getBytes());
        StringBuilder hexString = new StringBuilder();

        for(byte b : hashBytes){
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);    
        }

        return hexString.toString();
    }

    public Vilao(String nome, String codigo) throws NoSuchAlgorithmException, IOException{
        super(nome,codigo);
        this.hash = this.gerarHash(codigo);

        BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Viloes.txt"));
        String line;
        boolean objetoJaExiste = false;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            if (campos.length >= 2 && campos[1].equals(codigo)) {
                // Objeto já existe no arquivo
                objetoJaExiste = true;
                break;
            }
        }
        reader.close();
        // Escrever objeto no arquivo, se ele ainda não existe
        if (!objetoJaExiste) {
            FileWriter writer = new FileWriter("UrnaEletronica\\src\\Viloes.txt", true);
            writer.write(nome + "," + codigo + "," + hash + "," + votos + "\n");
            writer.close();
        }
    }
    public void atualizarVoto() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Viloes.txt"));
        StringBuilder lines = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            if (campos.length >= 2 && campos[1].equals(this.getCodigo())) {
                int novoVoto = Integer.parseInt(campos[3]) + 1;
                String novaLinha = campos[0] + "," + campos[1] + "," + campos[2] + "," + novoVoto;
                line = novaLinha;

            }
            lines.append(line).append("\n");
        }
        reader.close();
    
        FileWriter writer = new FileWriter("UrnaEletronica\\src\\Viloes.txt");
        writer.write(lines.toString());
        writer.close();
    }
    public void receberVoto() {
        this.votos++;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }
}