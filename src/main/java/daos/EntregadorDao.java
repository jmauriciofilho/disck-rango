package daos;

import connection.Conexao;
import models.Entregador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class EntregadorDao implements CrudDao<Entregador>{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Entregador entregador) {
        try {
            connection = conexao.open();
            sql = "INSERT INTO entregadores (nome, placaDoVeiculo) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, entregador.getNome());
            statement.setString(2, entregador.getPlacaVeiculo());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void update(Entregador entregador) {
        try {
            connection = conexao.open();
            sql = "UPDATE entregadores SET nome=?, placaDoVeiculo=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(3, entregador.getId());
            statement.setString(1, entregador.getNome());
            statement.setString(2, entregador.getPlacaVeiculo());
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void delete(int entregadorId) {
        try {
            connection = conexao.open();
            sql = "DELETE FROM entregadores WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, entregadorId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public Entregador find(String nome) {
        Entregador entregador = new Entregador();
        try {
            connection = conexao.open();
            sql = "SELECT id, nome, placaDoVeiculo FROM entregadores WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                entregador.setId(rs.getInt("id"));
                entregador.setNome(rs.getString("nome"));
                entregador.setPlacaVeiculo(rs.getString("placaDoVeiculo"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return entregador;
    }

    public List<Entregador> all() {
        List<Entregador> entregadores = new ArrayList<Entregador>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM entregadores";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        Entregador entregador = new Entregador();
                        entregador.setId(rs.getInt("id"));
                        entregador.setNome(rs.getString("nome"));
                        entregador.setPlacaVeiculo(rs.getString("placaDoVeiculo"));
                        entregadores.add(entregador);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return entregadores;
    }
}
