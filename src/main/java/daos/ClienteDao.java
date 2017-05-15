package daos;

import connection.Conexao;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void delete(Cliente cliente){
        try {
            connection = conexao.open();
            sql = "DELETE FROM clientes WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, cliente.getId());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void find(Cliente cliente) {

    }

    public void all() {

    }
}
