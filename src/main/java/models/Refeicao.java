package models;

/**
 * Created by mauricio on 16/05/17.
 */
public class Refeicao extends Item{

    private int id;

    public Refeicao(){}

    public Refeicao(int id, String nome, double valor) {
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

    @Override
    public String toString() {
        return "Refeicao{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", valor=" + valor +
                '}';
    }
}
