package controllers;

import daos.PedidoDao;
import models.ItensDoPedido;
import models.Pedido;

import java.util.List;

/**
 * Created by mauricio on 18/05/17.
 */
public class PedidoController {

    PedidoDao pedidoDao = new PedidoDao();

    public String create(Pedido pedido){
        pedidoDao.create(pedido);
        return "Pedido criado com sucesso.";
    }

    public String adicionarItemNoPedido(int pedidoId, int itemId){
        pedidoDao.adicionarItenNoPedido(pedidoId, itemId);
        return "Item adicionado ao pedido.";
    }

    public String removerItemDoPedido(int itensDoPedidoId){
        pedidoDao.removeItenDoPedido(itensDoPedidoId);
        return "Item removido do pedido";
    }

    public String delete(int pedidoId){
        pedidoDao.delete(pedidoId);
        return "Pedido exculido com sucesso";
    }

    public Pedido find(int id){
        return pedidoDao.find(id);
    }

    public List<Pedido> all(){
        return pedidoDao.all();
    }

    public List<ItensDoPedido> retornarItensDoPedido(){
        return pedidoDao.retornarItensDoPedido();
    }
}
