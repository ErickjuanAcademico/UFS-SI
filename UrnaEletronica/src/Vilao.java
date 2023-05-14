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
    private String caminhoImagem;

    Seguranca seguranca = new Seguranca();

    public Vilao(String nome) {
        this.nome = nome;
        this.votos = 0;
        
    }
    
    public Vilao(String nome, String codigo, String caminhoImagem) throws NoSuchAlgorithmException, IOException{
        super(nome,codigo);
        this.votos = 0;
        this.caminhoImagem = caminhoImagem;
        

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
            writer.write(nome + "," + codigo + "," + seguranca.gerarHash(getNome() + getCodigo()) + "," + votos + "," + getCaminhoImagem() + "\n");
            writer.close();
        }
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
    public String getCaminhoImagem() {
        return caminhoImagem;
    }

}