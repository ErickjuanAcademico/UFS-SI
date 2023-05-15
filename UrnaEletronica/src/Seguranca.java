import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Interfaces.iTesteDeIntegridade;

public class Seguranca implements iTesteDeIntegridade {
    //Classe que ira ter o papel de efetuar os testes de segurança da eleição.
    public Seguranca(){}
    
    public String gerarHash(String texto  ) throws NoSuchAlgorithmException{
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
    public String gerarHashArquivo(String arquivoTxt) throws IOException, NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
    try (DigestInputStream inputStream = new DigestInputStream(new FileInputStream(arquivoTxt), digest)) {
      // Lê o arquivo para calcular a hash
      byte[] buffer = new byte[8192];
      while (inputStream.read(buffer) != -1) {}
    }
    byte[] hashBytes = digest.digest();
    StringBuilder hexString = new StringBuilder();

    for (byte b : hashBytes) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }

    return hexString.toString();
  }
    
  
  public void verificarArquivo(){
    

    }
    
    public void adicionarHashEmArquivo(String caminhoDoArquivoOriginal, String caminhoDoArquivoNovo) throws IOException, NoSuchAlgorithmException {
      // Gera a hash do arquivo original
      String hash = gerarHashArquivo(caminhoDoArquivoOriginal);
      
      // Cria um novo arquivo com o caminho especificado
      File arquivoNovo = new File(caminhoDoArquivoNovo);
      
      // Cria um escritor para escrever no novo arquivo
      BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoNovo));
      
      // Escreve a hash no novo arquivo
      escritor.write(hash);
      
      // Fecha o escritor
      escritor.close();
  }

   public boolean verificarHashArquivo(String arquivoTxt) {
    boolean chaveVerificadora = true;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(arquivoTxt));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            String nome = campos[0];
            String codigo = campos[1];
            String hashOriginal = campos[2];
            String hashGerada = gerarHash(nome + codigo);

            if (!hashGerada.equals(hashOriginal)) {
                chaveVerificadora = false;
                break;
            }
        }
        reader.close();
    } catch (IOException | NoSuchAlgorithmException e) {
        e.printStackTrace();
        
    }
    return chaveVerificadora;
}


}
