package controllers;

import daos.BebidaDao;
import models.Bebida;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class BebidaController implements CrudController<Bebida>{

    private BebidaDao bebidaDao = new BebidaDao();

    public String create(Bebida bebida) {
        bebidaDao.create(bebida);
        return "Bebida cadastrada com sucesso!";
    }

    public String update(Bebida bebida) {
        bebidaDao.update(bebida);
        return "Bebida atualizada com sucesso.";
    }

    public String alterarQuantidaEmEstoque(int bebidaId, int quantidade){
        bebidaDao.alterarQuantidaEmEstoque(bebidaId, quantidade);
        return "Quantidade de bebidas em estoque alteradas.";
    }

    public Integer bebidaEmEstoque(int bebidaId){
        return bebidaDao.bebidaEmEstoque(bebidaId);
    }

    public String delete(int bebidaId) {
        bebidaDao.delete(bebidaId);
        return "Bebida excluida com sucesso.";
    }

    public Bebida find(String nome) {
        return bebidaDao.find(nome);
    }

    public List<Bebida> all() {
        return bebidaDao.all();
    }
}
