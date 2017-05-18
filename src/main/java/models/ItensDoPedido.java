package models;

/**
 * Created by mauricio on 18/05/17.
 */
public class ItensDoPedido {

    private int id;
    private int pedidoId;
    private int itemId;

    public ItensDoPedido(){}

    public ItensDoPedido(int id, int pedidoId, int itemId) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
