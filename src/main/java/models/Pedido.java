package models;

/**
 * Created by mauricio on 16/05/17.
 */
public class Pedido {

    private int id;
    private String dataDoPedido;
    private double valor;
    private String tipoDePagamento;

    public Pedido(){}

    public Pedido(int id, String data, double valor, String tipoDePagamento) {
        this.id = id;
        this.dataDoPedido = data;
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
        return dataDoPedido;
    }

    public void setData(String dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
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
