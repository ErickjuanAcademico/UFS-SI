import Interfaces.iGerarHash;
import Interfaces.iVotar;

public abstract class Pessoa implements iVotar, iGerarHash{
    private String nome;
    private String codigo;
    private String hash;
    private boolean chaveDeVoto;

    
public Pessoa(String nome, String codigo){
    this.chaveDeVoto = false;
    this.nome = nome;
    this.codigo = codigo;
}
public void setChaveDeVotoTrue() {
    this.chaveDeVoto = true;
}
public String getHash() {
    return hash;
}
public String getNome() {
    return nome;
}
public String getCodigo() {
    return codigo;
}
public boolean jaVotou(){
    return this.chaveDeVoto;
}
}

