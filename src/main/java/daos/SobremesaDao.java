package daos;

import connection.Conexao;
import models.Sobremesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class SobremesaDao implements CrudDao<Sobremesa>{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Sobremesa sobremesa) {
        try {
            connection = conexao.open();
            sql = "INSERT INTO sobremesa (nome, valor) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, sobremesa.getNome());
            statement.setDouble(2, sobremesa.getValor());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void update(Sobremesa sobremesa) {
        try {
            connection = conexao.open();
            sql = "UPDATE sobremesa SET nome=?, valor=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(3, sobremesa.getId());
            statement.setString(1, sobremesa.getNome());
            statement.setDouble(2, sobremesa.getValor());
            statement.executeUpdate();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void delete(int sobremesaId) {
        try {
            connection = conexao.open();
            sql = "DELETE FROM sobremesa WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sobremesaId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public Sobremesa find(String nome) {
        Sobremesa sobremesa = new Sobremesa();
        try {
            connection = conexao.open();
            sql = "SELECT id, nome, valor FROM sobremesa WHERE nome=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                sobremesa.setId(rs.getInt("id"));
                sobremesa.setNome(rs.getString("nome"));
                sobremesa.setValor(rs.getDouble("valor"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return sobremesa;
    }

    public List<Sobremesa> all() {
        List<Sobremesa> sobremesas = new ArrayList<Sobremesa>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM sobremesa";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        Sobremesa sobremesa = new Sobremesa();
                        sobremesa.setId(rs.getInt("id"));
                        sobremesa.setNome(rs.getString("nome"));
                        sobremesa.setValor(rs.getDouble("valor"));
                        sobremesas.add(sobremesa);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return sobremesas;
    }
}
