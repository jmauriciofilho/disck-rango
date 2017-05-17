package controllers;

import daos.EntregadorDao;
import models.Entregador;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class EntregadorController implements CrudController<Entregador>{

    private EntregadorDao entregadorDao = new EntregadorDao();

    public String create(Entregador entregador) {
        entregadorDao.create(entregador);
        return "Entregador cadastrado com sucesso.";
    }

    public String update(Entregador entregador) {
        entregadorDao.update(entregador);
        return "Entregador atualizado com sucesso.";
    }

    public String delete(int entregadorId) {
        entregadorDao.delete(entregadorId);
        return "Entregador deletado com sucesso.";
    }

    public Entregador find(String nome) {
        return entregadorDao.find(nome);
    }

    public List<Entregador> all() {
        return entregadorDao.all();
    }
}
