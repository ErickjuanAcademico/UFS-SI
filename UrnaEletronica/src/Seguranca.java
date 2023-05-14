import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Interfaces.iTesteDeIntegridade;

public class Seguranca implements iTesteDeIntegridade {
    //Classe que ira ter o papel de efetuar os testes de segurança da eleição.
    public Seguranca(){}
    
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
    public String gerarHashArquivo(String string) throws IOException, NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
    try (DigestInputStream inputStream = new DigestInputStream(new FileInputStream(string), digest)) {
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

    
    
    
    public void verificarHash(String cpf){
      

    }

    public void verificarArquivos(){

    }
    
}
