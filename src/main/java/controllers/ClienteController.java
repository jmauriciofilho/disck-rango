package controllers;

import daos.ClienteDao;
import models.Cliente;

import java.util.List;

/**
 * Created by mauricio on 15/05/17.
 */
public class ClienteController implements CrudController<Cliente>{

    private ClienteDao clienteDao = new ClienteDao();

    public String create(Cliente cliente){
        clienteDao.create(cliente);
        return "Cliente cadastrado com sucesso.";
    }

    public String update(Cliente cliente){
        clienteDao.update(cliente);
        return "Cliente atualizado com sucesso.";
    }

    public String ativarCliente(int clienteId){
        clienteDao.ativarCliente(clienteId);
        return "Cliente ativado.";
    }

    public String desativarCliente(int clienteId){
        Cliente cliente = find(clienteId);
        if (cliente.getQuantidadeDevolucoes() >= 3){
            clienteDao.desativarCliente(clienteId);
            return "Cliente desativado";
        }else{
            return "Cliente não pode ser desativado.";
        }

    }

    public String registrarDevolucao(int clienteId){
        Cliente cliente = find(clienteId);
        int quantidadeDevolucao = cliente.getQuantidadeDevolucoes() + 1;
        clienteDao.registrarDevolucao(clienteId, quantidadeDevolucao);
        return "Devolução registrada.";
    }

    public String delete(int clienteId){
        clienteDao.delete(clienteId);
        return "Cliente removido com sucesso.";
    }

    public Cliente find(String nome){
        return clienteDao.find(nome);
    }

    public Cliente find(int clienteId){
        return clienteDao.find(clienteId);
    }

    public List<Cliente> all(){
        return clienteDao.all();
    }
}
