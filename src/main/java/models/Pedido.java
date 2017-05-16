package models;

/**
 * Created by mauricio on 16/05/17.
 */
public class Pedido {

    private int id;
    private String data;
    private double valor;
    private String tipoDePagamento;

    public Pedido(){}

    public Pedido(int id, String data, double valor, String tipoDePagamento) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.tipoDePagamento = tipoDePagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(String tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }
}
