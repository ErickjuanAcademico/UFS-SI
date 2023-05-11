import Interfaces.iReceberVoto;

import java.io.Serializable;

public class Vilao implements Serializable, iReceberVoto {
    private String nome;
    private int votos;

    public Vilao(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public void receberVoto() {
        this.votos++;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }
}