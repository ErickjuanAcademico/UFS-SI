
import Interfaces.iVotar;

public abstract class Pessoa{
    private String nome;
    private String codigo;
    private boolean chaveDeVoto;

    
public Pessoa(String nome, String codigo){
    this.chaveDeVoto = false;
    this.nome = nome;
    this.codigo = codigo;
}
public void setChaveDeVotoTrue() {
    this.chaveDeVoto = true;
}
public String getNome() {
    return nome;
}
public String getCodigo() {
    return codigo;
}
public boolean getChaveDeVoto(){
    return this.chaveDeVoto;
}
}

