import Interfaces.iReceberVoto;

public class Vilao extends Pessoa implements iReceberVoto{
    private String nome;
    private int votos;
    private String Hash;


public Vilao(String nome, String codigo){
    super(nome,codigo);

}
@Override
public void receberVoto(){
    this.votos += 1;
}
public void setVotos(int votos) {
    this.votos = votos;
}

}