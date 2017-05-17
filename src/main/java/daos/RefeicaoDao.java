package daos;

import connection.Conexao;
import models.Refeicao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class RefeicaoDao implements CrudDao<Refeicao>{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Refeicao refeicao) {
        try {
            connection = conexao.open();
            sql = "INSERT INTO refeicoes (nome, valor) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, refeicao.getNome());
            statement.setDouble(2, refeicao.getValor());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void update(Refeicao refeicao) {
        try {
            connection = conexao.open();
            sql = "UPDATE refeicoes SET nome=?, valor=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(3, refeicao.getId());
            statement.setString(1, refeicao.getNome());
            statement.setDouble(2, refeicao.getValor());
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void delete(int refeicaoId) {
        try {
            connection = conexao.open();
            sql = "DELETE FROM refeicoes WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, refeicaoId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public Refeicao find(String nome) {
        Refeicao refeicao = new Refeicao();
        try {
            connection = conexao.open();
            sql = "SELECT id, nome, valor FROM refeicoes WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                refeicao.setId(rs.getInt("id"));
                refeicao.setNome(rs.getString("nome"));
                refeicao.setValor(rs.getDouble("valor"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return refeicao;
    }

    public List<Refeicao> all() {
        List<Refeicao> refeicoes = new ArrayList<Refeicao>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM refeicoes";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        Refeicao refeicao = new Refeicao();
                        refeicao.setId(rs.getInt("id"));
                        refeicao.setNome(rs.getString("nome"));
                        refeicao.setValor(rs.getDouble("valor"));
                        refeicoes.add(refeicao);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return refeicoes;
    }
}
