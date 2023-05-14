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
    public String gerarHashArquivo(){}
    
    
    
    public void verificarHash(){

    }

    public void verificarArquivos(){

    }
    
}
