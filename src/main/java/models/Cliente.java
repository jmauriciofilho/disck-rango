package models;

/**
 * Created by mauricio on 14/05/17.
 */
public class Cliente extends Pessoa{

    private int id;
    private String endereco;
    private String telefone;
    private String pontoDeReferencia;
    private boolean ativo;

    public Cliente(){}

    public Cliente(int id, String nome, String endereco, String telefone, String pontoDeReferencia) {
        this.id = id;
        super.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pontoDeReferencia = pontoDeReferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente{ id='" + id + '\''+
                ", nome='" + nome + '\''+
                ", endereço='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
