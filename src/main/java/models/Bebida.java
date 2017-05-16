package models;

/**
 * Created by mauricio on 16/05/17.
 */
public class Bebida extends Item{

    private int id;
    private int quantideEmEstoque;

    public Bebida(){}

    public Bebida(int id, String nome, double valor, int quantideEmEstoque) {
        this.id = id;
        super.nome = nome;
        super.valor = valor;
        this.quantideEmEstoque = quantideEmEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantideEmEstoque() {
        return quantideEmEstoque;
    }

    public void setQuantideEmEstoque(int quantideEmEstoque) {
        this.quantideEmEstoque = quantideEmEstoque;
    }
}
