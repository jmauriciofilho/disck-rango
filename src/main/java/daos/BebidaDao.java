package daos;

import connection.Conexao;
import models.Bebida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class BebidaDao implements CrudDao<Bebida>{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Bebida bebida) {
        try {
            connection = conexao.open();
            sql = "INSERT INTO bebidas (nome, valor, quantidadeEmEstoque) VALUES (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, bebida.getNome());
            statement.setDouble(2, bebida.getValor());
            statement.setInt(3, bebida.getQuantideEmEstoque());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void update(Bebida bebida) {
        try {
            connection = conexao.open();
            sql = "UPDATE bebidas SET nome=?, valor=?, quantidadeEmEstoque=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(4, bebida.getId());
            statement.setString(1, bebida.getNome());
            statement.setDouble(2, bebida.getValor());
            statement.setDouble(3, bebida.getQuantideEmEstoque());
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void alterarQuantidaEmEstoque(int bebidaId, int quantidade){
        try {
            connection = conexao.open();
            sql = "UPDATE bebidas SET quantidadeEmEstoque=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(2, bebidaId);
            statement.setInt(1, quantidade);
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void delete(int bebidaId) {
        try {
            connection = conexao.open();
            sql = "DELETE FROM bebidas WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bebidaId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public Integer bebidaEmEstoque(int bebidaId){
        Bebida bebida = new Bebida();
        Integer quantidade = 0;
        try {
            connection = conexao.open();
            sql = "SELECT quantidadeEmEstoque FROM bebidas WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bebidaId);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
               quantidade = rs.getInt("quantidadeEmEstoque");
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
            quantidade = null;
        }
        return quantidade;
    }

    public Bebida find(String nome) {
        Bebida bebida = new Bebida();
        try {
            connection = conexao.open();
            sql = "SELECT id, nome, valor, quantidadeEmEstoque FROM bebidas WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setValor(rs.getDouble("valor"));
                bebida.setQuantideEmEstoque(rs.getInt("quantidadeEmEstoque"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return bebida;
    }

    public List<Bebida> all() {
        List<Bebida> bebidas = new ArrayList<Bebida>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM bebidas";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        Bebida bebida = new Bebida();
                        bebida.setId(rs.getInt("id"));
                        bebida.setNome(rs.getString("nome"));
                        bebida.setValor(rs.getDouble("valor"));
                        bebida.setQuantideEmEstoque(rs.getInt("quantidadeEmEstoque"));
                        bebidas.add(bebida);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return bebidas;
    }
}
