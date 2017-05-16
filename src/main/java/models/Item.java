package models;

/**
 * Created by mauricio on 16/05/17.
 */
public abstract class Item {
    protected String nome;
    protected double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
