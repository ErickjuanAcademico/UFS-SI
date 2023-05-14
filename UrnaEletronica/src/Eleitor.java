import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Eleitor extends Pessoa{
    
    Seguranca seguranca = new Seguranca();

    public Eleitor(){}
    
    public Eleitor(String nome, String codigo) throws NoSuchAlgorithmException, IOException{
        super(nome,codigo);

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
            writer.write(nome + "," + codigo + "," + seguranca.gerarHash((getNome() + getCodigo())) + "," + getChaveDeVoto() + "\n");
            writer.close();
        }
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


