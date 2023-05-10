import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;



public class Eleitor extends Pessoa {
    private String hash;
    
    ArrayList<Eleitor> eleitores = new ArrayList<Eleitor>();
    
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


    public Eleitor(String nome, String codigo) throws NoSuchAlgorithmException{
        super(nome,codigo);
        eleitores.add(this);
        this.hash = this.gerarHash(codigo);
    }
    public String getHash() {
        return hash;
    }

    public void votar(){
        System.out.println("aeiou");
    }
}


