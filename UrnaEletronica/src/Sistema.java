import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
    /*a classe Sistema será responsavel por portar todo o codigo voltado para execução da nossa eleição e utilizará de todas as classes
      que necessitar. */
public class Sistema {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        FileWriter clearEleitores = new FileWriter("UrnaEletronica\\src\\Eleitores.txt", false);
         clearEleitores.write("");
         clearEleitores.close();
        FileWriter clearViloes = new FileWriter("UrnaEletronica\\src\\Viloes.txt", false);
        clearViloes.write("");
        clearViloes.close(); 
         
        Eleitor eleitor1 = new Eleitor("Erick Juan", "04809622517");
        Eleitor eleitor2 = new Eleitor("Savio Luan", "03767112051"); 
        Eleitor eleitor3 = new Eleitor("Joao Pedro", "82165783003");
        Eleitor eleitor4 = new Eleitor("Gabriel Argolo", "91397641096");
        Eleitor eleitor5 = new Eleitor("Antonio Vitor", "73246716080");
        Eleitor eleitor6 = new Eleitor("Diogo Eduardo", "03865973086");
        Eleitor eleitor7 = new Eleitor("Beatriz Silva", "61295312069");
        Eleitor eleitor8 = new Eleitor("Augusto Cesar", "13848007002");
        Eleitor eleitor9 = new Eleitor("Kalil Bispo", "38431895012");
        Eleitor eleitor10 = new Eleitor("Naruto Uzumaki", "43989012053");
        Eleitor eleitor11 = new Eleitor("Sasuke Uchiha", "83359025016");
        Vilao vilao1 = new Vilao("Darth Vader", "666");
        Vilao vilao2 = new Vilao("Coringa", "888");
        Vilao vilao3 = new Vilao("Voldemort", "111");
        Vilao vilao4 = new Vilao("Satanas", "333");
        Vilao vilao5 = new Vilao("Dr. Octopus", "777");
        Vilao vilao6 = new Vilao("Thanos", "999");
        
        Main_Screen startMain_Screen = new Main_Screen();  
    }
}
