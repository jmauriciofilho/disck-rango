import controllers.ClienteController;
import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public class RetornarCliente {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        String nome = "Maurício";

        Cliente cliente = clienteController.find(nome);

        System.out.println(cliente.toString());
    }
}
