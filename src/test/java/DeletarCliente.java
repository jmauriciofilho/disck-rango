import controllers.ClienteController;
import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public class DeletarCliente {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();

        cliente.setId(2);

        System.out.println(clienteController.delete(cliente));
    }
}
