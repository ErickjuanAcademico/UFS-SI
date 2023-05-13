import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Eleicao {
    String vencedor;
    String viloes = "UrnaEletronica\\src\\Viloes.txt";
    
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
                int votos = Integer.parseInt(dados[3]);
                if (votos > maxVotos) {
                    vencedor = nome;
                    maxVotos = votos;
                    qtdEmpates = 0;
                    empates = new StringBuilder();
                } else if (votos == maxVotos) {
                    qtdEmpates++;
                    if (qtdEmpates == 1) {
                        empates.append(vencedor);
                    }
                    empates.append(", ");
                    empates.append(nome);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo " + viloes + ": " + e.getMessage());
        }

        if (qtdEmpates == 0) {
            return vencedor;
        } else {
            return empates.toString();
        }
    }
}


