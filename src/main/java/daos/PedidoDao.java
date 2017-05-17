package daos;

import connection.Conexao;
import models.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class PedidoDao implements CrudDao<Pedido>{

    private Conexao conexao = new Conexao();
    private Connection connection;
    private PreparedStatement statement;
    private String sql;

    public void create(Pedido pedido) {

    }

    public void update(Pedido pedido) {

    }

    public void delete(int pedidoId) {

    }

    public Pedido find(String nome) {
        return null;
    }

    public List<Pedido> all() {
        return null;
    }
}
