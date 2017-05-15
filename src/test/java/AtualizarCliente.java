import controllers.ClienteController;
import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public class AtualizarCliente {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();

        cliente.setId(2);
        cliente.setNome("Paulo");
        cliente.setEndereco("rua M");
        cliente.setTelefone("34567893");
        cliente.setPontoDeReferencia("Proximo ao hopital de messejana.");

        System.out.println(clienteController.update(cliente));
    }
}
