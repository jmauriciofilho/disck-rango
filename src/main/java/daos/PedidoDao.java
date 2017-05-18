package daos;

import connection.Conexao;
import models.Item;
import models.ItensDoPedido;
import models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class PedidoDao{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Pedido pedido) {
        try {
            connection = conexao.open();
            sql = "INSERT INTO pedidos (clienteId, entregadorId, dataDoPedido, valor, tipoDePagamento) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pedido.getClienteId());
            statement.setInt(2, pedido.getEntregadorId());
            statement.setString(3, pedido.getDataDoPedido());
            statement.setDouble(4, pedido.getValor());
            statement.setString(5, pedido.getTipoDePagamento());
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void adicionarItenNoPedido(int pedidoId, int itemId){
        try {
            connection = conexao.open();
            sql = "INSERT INTO itensDoPedido (pedidoId, itemId) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pedidoId);
            statement.setInt(2, itemId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void removeItenDoPedido(int itensDoPedidoId){
        try {
            connection = conexao.open();
            sql = "DELETE FROM itensDoPedido WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, itensDoPedidoId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public void delete(int pedidoId) {
        try {
            connection = conexao.open();
            sql = "DELETE FROM pedidos WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pedidoId);
            statement.execute();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
    }

    public Pedido find(int id) {
        Pedido pedido = new Pedido();
        try {
            connection = conexao.open();
            sql = "SELECT id, clienteId, entregadorId, dataDoPedido, valor, tipoDePagamento FROM pedidos WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                pedido.setId(rs.getInt("id"));
                pedido.setClienteId(rs.getInt("clienteId"));
                pedido.setEntregadorId(rs.getInt("entregadorId"));
                pedido.setDataDoPedido(rs.getString("dataDoPedido"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setTipoDePagamento(rs.getString("tipoDoPagamento"));
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return pedido;
    }

    public List<Pedido> all() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM pedidos";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        Pedido pedido = new Pedido();
                        pedido.setId(rs.getInt("id"));
                        pedido.setClienteId(rs.getInt("clienteId"));
                        pedido.setEntregadorId(rs.getInt("entregadorId"));
                        pedido.setDataDoPedido(rs.getString("dataDoPedido"));
                        pedido.setValor(rs.getDouble("valor"));
                        pedido.setTipoDePagamento(rs.getString("tipoDoPagamento"));
                        pedidos.add(pedido);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }

        return pedidos;
    }

    public List<ItensDoPedido> retornarItensDoPedido(){
        List<ItensDoPedido> items = new ArrayList<ItensDoPedido>();
        try {
            connection = conexao.open();
            sql = "SELECT * FROM pedidos";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    if (rs.first()){
                        ItensDoPedido iten = new ItensDoPedido();
                        iten.setId(rs.getInt("id"));
                        iten.setPedidoId(rs.getInt("pedidoId"));
                        iten.setItemId(rs.getInt("itemId"));
                        items.add(iten);
                    }
                }
            }
            rs.close();
            conexao.close();
        }catch (SQLException e){
            conexao.close();
            e.printStackTrace();
        }
        return items;
    }
}
