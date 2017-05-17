package controllers;

import daos.RefeicaoDao;
import models.Refeicao;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class RefeicaoController implements CrudController<Refeicao>{

    private RefeicaoDao refeicaoDao = new RefeicaoDao();

    public String create(Refeicao refeicao) {
        refeicaoDao.create(refeicao);
        return "Refeição cadastrada com sucesso.";
    }

    public String update(Refeicao refeicao) {
        refeicaoDao.update(refeicao);
        return "Refeição altarada com sucesso.";
    }

    public String delete(int refeicaoId) {
        refeicaoDao.delete(refeicaoId);
        return "Refeição excluida com sucesso.";
    }

    public Refeicao find(String nome) {
        return refeicaoDao.find(nome);
    }

    public List<Refeicao> all() {
        return refeicaoDao.all();
    }
}
