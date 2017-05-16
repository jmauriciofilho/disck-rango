package models;

/**
 * Created by mauricio on 16/05/17.
 */
public class Entregador extends Pessoa{

    private int id;
    private String placaVeiculo;

    public Entregador(){}

    public Entregador(int id, String nome, String placaVeiculo) {
        this.id = id;
        super.nome = nome;
        this.placaVeiculo = placaVeiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}
