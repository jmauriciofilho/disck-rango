package controllers;

import daos.ClienteDao;
import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public class ClienteController {

    ClienteDao clienteDao = new ClienteDao();

    public String create(Cliente cliente){
        clienteDao.create(cliente);
        return "Cliente cadastrado com sucesso.";
    }

    public String update(Cliente cliente){
        clienteDao.update(cliente);
        return "Cliente atualizado com sucesso.";
    }

    public String delete(int clienteId){
        clienteDao.delete(clienteId);
        return "Cliente removido com sucesso.";
    }

    public Cliente find(String nome){
        return clienteDao.find(nome);
    }
}
