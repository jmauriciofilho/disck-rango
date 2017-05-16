package models;

/**
 * Created by mauricio on 14/05/17.
 */
public abstract class Pessoa {

    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
