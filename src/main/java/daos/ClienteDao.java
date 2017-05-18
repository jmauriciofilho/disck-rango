package daos;

import connection.Conexao;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 14/05/17.
 */
public class ClienteDao implements CrudDao<Cliente>{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Cliente cliente){
        try {
            connection = conexao.open();
            sql = "INSERT INTO clientes (nome, endereco, telefone, pontoDeReferencia) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getPontoDeReferencia());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void update(Cliente cliente){
        try {
            connection = conexao.open();
            sql = "UPDATE clientes SET nome=?, endereco=?, telefone=?, pontoDeReferencia=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(5, cliente.getId());
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getPontoDeReferencia());
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void ativarCliente(int clienteId){
        try {
            connection = conexao.open();
            sql = "UPDATE clientes SET ativo=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(2, clienteId);
            statement.setBoolean(1, true);
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void desativarCliente(int clienteId){
        try {
            connection = conexao.open();
            sql = "UPDATE clientes SET ativo=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(2, clienteId);
            statement.setBoolean(1, false);
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void registrarDevolucao(int clienteId, int quantidadeDevolucoes){
        try {
            connection = conexao.open();
            sql = "UPDATE clientes SET quantidadeDevolucoes=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(2, clienteId);
            statement.setInt(1, quantidadeDevolucoes);
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void delete(int clienteId){
        try {
            connection = conexao.open();
            sql = "DELETE FROM clientes WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, clienteId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public Cliente find(String nome) {
        Cliente cliente = new Cliente();
        try {
            connection = conexao.open();
            sql = "SELECT id, nome, endereco, telefone FROM clientes WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return cliente;
    }

    public Cliente find(int clienteId) {
        Cliente cliente = new Cliente();
        try {
            connection = conexao.open();
            sql = "SELECT id, nome, endereco, telefone FROM clientes WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, clienteId);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setPontoDeReferencia(rs.getString("pontoDeReferencia"));
                cliente.setAtivo(rs.getBoolean("ativo"));
                cliente.setQuantidadeDevolucoes(rs.getInt("quantidadeDevolucoes"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return cliente;
    }

    public List<Cliente> all() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM clientes";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        Cliente cliente = new Cliente();
                        cliente.setId(rs.getInt("id"));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setEndereco(rs.getString("endereco"));
                        cliente.setTelefone(rs.getString("telefone"));
                        cliente.setPontoDeReferencia(rs.getString("pontoDeReferencia"));
                        cliente.setAtivo(rs.getBoolean("ativo"));
                        cliente.setQuantidadeDevolucoes(rs.getInt("quantidadeDevolucoes"));
                        clientes.add(cliente);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

       return clientes;
    }
}
