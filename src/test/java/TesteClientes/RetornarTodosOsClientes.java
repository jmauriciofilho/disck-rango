package TesteClientes;

import controllers.ClienteController;
import models.Cliente;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class RetornarTodosOsClientes {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        List<Cliente> clientes = clienteController.all();

        for (int i = 0; i < clientes.size(); i++){
            System.out.println(clientes.get(i).toString());
        }
    }
}
