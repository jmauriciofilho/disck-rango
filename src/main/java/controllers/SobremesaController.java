package controllers;

import daos.SobremesaDao;
import models.Sobremesa;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class SobremesaController implements CrudController<Sobremesa>{

    private SobremesaDao sobremesaDao = new SobremesaDao();

    public String create(Sobremesa sobremesa) {
        sobremesaDao.create(sobremesa);
        return "Sobremesa cadastrada com sucesso.";
    }

    public String update(Sobremesa sobremesa) {
        sobremesaDao.update(sobremesa);
        return "Sobremesa atualizada com sucesso.";
    }

    public String delete(int sobremesaId) {
        sobremesaDao.delete(sobremesaId);
        return "Sobremesa excluida com sucesso.";
    }

    public Sobremesa find(String nome) {
        return sobremesaDao.find(nome);
    }

    public List<Sobremesa> all() {
        return sobremesaDao.all();
    }
}
