package models;

/**
 * Created by mauricio on 16/05/17.
 */
public class Sobremesa extends Item{

    private int id;

    public Sobremesa(){}

    public Sobremesa(int id, String nome, double valor) {
        this.id = id;
        super.nome = nome;
        super.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
