package controllers;

import daos.PedidoDao;
import models.ItensDoPedido;
import models.Pedido;

import java.util.List;

/**
 * Created by mauricio on 18/05/17.
 */
public class PedidoController {

    private PedidoDao pedidoDao = new PedidoDao();

    public String create(Pedido pedido){
        pedidoDao.create(pedido);
        return "Pedido criado com sucesso.";
    }

    public String adicionarItemNoPedido(int pedidoId, int itemId){
        Pedido pedido = find(pedidoId);
        if (pedido.isPendente()){
            pedidoDao.adicionarItenNoPedido(pedidoId, itemId);
            return "Item adicionado ao pedido.";
        }else {
            return "Não se pode alterar este pedido.";
        }
    }

    public String removerItemDoPedido(int pedidoId, int itensDoPedidoId){
        Pedido pedido = find(pedidoId);
        if (pedido.isPendente()){
            pedidoDao.removeItenDoPedido(itensDoPedidoId);
            return "Item removido do pedido";
        }else{
            return "Nãp se pode alterar este pedido";
        }

    }

    public String alterarEstadoDoPedidoEAtribuirEntregador(int pedidoId, int entregadorId){
        pedidoDao.alterarEstadoDoPedidoEAtribuirEntregador(pedidoId, entregadorId);
        return "Estado do pedido alterado com sucesso.";
    }

    public String devolucaoDoPedido(int pedidoId, boolean devolvido){
        pedidoDao.devolucaoDoPedido(pedidoId, devolvido);
        return "Estado de devolução alterado.";
    }

    public String delete(int pedidoId){
        Pedido pedido = find(pedidoId);
        if (pedido.isPendente() || !pedido.isDevolvido()) {
            pedidoDao.delete(pedidoId);
            return "Pedido excluido com sucesso";
        }else {
            return "Pedido não pode ser removido";
        }
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
