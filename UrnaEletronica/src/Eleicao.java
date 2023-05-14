import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Eleicao {
    String vencedor;
    String viloes = "UrnaEletronica\\src\\Viloes.txt";
    Arraylist empatesList = null;
    
    public Eleicao(){}
    public String revelarVencedor(){
        String line;
        int maxVotos = 0;
        int qtdEmpates = 0;
        StringBuilder empates = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(viloes));
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                String nome = dados[0];
                int codigo = Integer.parseInt(dados[1]);
                String hash = dados[2];
                String imagem = dados[4];
                int votos = Integer.parseInt(dados[3]);
                if (votos > maxVotos) {
                    vencedor = imagem;
                    maxVotos = votos;
                    qtdEmpates = 0;
                    empates = new StringBuilder();
                } else if (votos == maxVotos) {
                    qtdEmpates++;
                    empatesList.add(nome);
                    
                    if (qtdEmpates > 0) {
                        for (String empate : empatesList) {
                            empates.append(empate);
                            empates.append(",");
                        }
                    
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo " + viloes + ": " + e.getMessage());
        }

        if (qtdEmpates == 0) {
            return vencedor;
        } else {
            String empatesString = empates.toString();

        
        return empatesString;
        }
    }
    
    public void resetarVotacao(){
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
                String novaLinha = campos[0] + "," + campos[1] + "," + campos[2] + "," + "0" + "," + campos[4];
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


    public boolean codigoExiste(String codigo) { //Verifica se o codigo de Eleitor está cadastrado no banco de dados e devolve true caso exista.
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
    

    public void votar(Eleitor eleitor, Vilao vilao, Seguranca seguranca) throws NoSuchAlgorithmException, IOException{
        FileWriter writerVotos = new FileWriter("UrnaEletronica\\src\\Votos.txt", true);
        writerVotos.write(eleitor.getCodigo() + "," + vilao.getCodigo() + "," + seguranca.gerarHash(eleitor.getCodigo() + vilao.getCodigo()) + "\n");
        writerVotos.close();
        
        BufferedReader reader = new BufferedReader(new FileReader("UrnaEletronica\\src\\Viloes.txt"));
        StringBuilder lines = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            if (campos.length >= 2 && campos[1].equals(vilao.getCodigo())) {
                int novoVoto = Integer.parseInt(campos[3]) + 1;
                String novaLinha = campos[0] + "," + campos[1] + "," + campos[2] + "," + novoVoto + "," + campos[4];
                line = novaLinha;
                vilao.receberVoto();

            }
            lines.append(line).append("\n");
        }
        reader.close();
    
        FileWriter writerViloes = new FileWriter("UrnaEletronica\\src\\Viloes.txt");
        writerViloes.write(lines.toString());
        writerViloes.close();

    }
}




