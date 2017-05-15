import controllers.ClienteController;
import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public class CadastrarClientes {

    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        Cliente cliente = new Cliente();

        cliente.setNome("Paulo");
        cliente.setEndereco("rua M");
        cliente.setTelefone("34567893");
        cliente.setPontoDeReferencia("Proximo ao hopital de messejana.");

        System.out.println(clienteController.create(cliente));
    }
}
