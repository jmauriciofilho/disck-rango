package controllers;

import models.Bebida;
import models.Refeicao;
import models.Sobremesa;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public class CardapioController {

    private RefeicaoController refeicaoController = new RefeicaoController();
    private SobremesaController sobremesaController = new SobremesaController();
    private BebidaController bebidaController = new BebidaController();

    public List<Refeicao> refeicoes(){
        return refeicaoController.all();
    }

    public List<Sobremesa> sobremesas(){
        return sobremesaController.all();
    }

    public List<Bebida> bebidas(){
        return bebidaController.all();
    }
}
