package TesteClientes;

import controllers.ClienteController;
import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public class DeletarCliente {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        int clienteId = 3;

        System.out.println(clienteController.delete(clienteId));
    }
}
