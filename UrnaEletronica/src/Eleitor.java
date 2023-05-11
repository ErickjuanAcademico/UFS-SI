import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Eleitor extends Pessoa{
    private String hash;
    
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

    public Eleitor(){}
    
    public Eleitor(String nome, String codigo) throws NoSuchAlgorithmException, IOException{
        super(nome,codigo);
        this.hash = this.gerarHash(codigo);

        /* Verifica se o objeto a ser criado ja existe no arquivo txt para evitar que seja adicionado uma repetição do mesmo eleitor */
        BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Eleitores.txt"));
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
            FileWriter writer = new FileWriter("UrnaEletronica\\src\\Eleitores.txt", true);
            writer.write(nome + "," + codigo + "," + hash + "," + getChaveDeVoto() + "\n");
            writer.close();
        }
    }
    public String getHash() {
        return hash;
    }
    public boolean chaveJaUtilizada() throws IOException { 
        /*lê o arquivo de eleitores e retorna a chave de voto (true ou false) do eleitor selecionado pelo codigo*/
        BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Eleitores.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            if (campos.length >= 2 && campos[1].equals(this.getCodigo()) && campos[3].equals("true")) {
                // Chave já utilizada
                reader.close();
                return true;
            }
        }
        reader.close();
        // Chave ainda não utilizada
        return false;
    }
    
    public void atualizarChaveDeVoto() throws IOException {
        /*Atualiza a chave de voto do eleitor selecionado para true logo*/
        BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Eleitores.txt"));
        StringBuilder lines = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            if (campos.length >= 2 && campos[1].equals(this.getCodigo())) {
                line = line.replace(",false", ",true");
            }
            lines.append(line).append("\n");
        }
        reader.close();
    
        FileWriter writer = new FileWriter("UrnaEletronica\\src\\Eleitores.txt");
        writer.write(lines.toString());
        writer.close();
    }
}


