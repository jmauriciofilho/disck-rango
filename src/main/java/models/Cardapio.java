package models;

import java.util.List;

/**
 * Created by mauricio on 16/05/17.
 */
public class Cardapio {

    public void MostrarCardapio(List<Refeicao> refeicoes, List<Sobremesa> sobremesas, List<Bebida> bebidas){
        for (Refeicao refeicao : refeicoes){
            System.out.println(refeicao.toString());
        }
        for (Sobremesa sobremesa : sobremesas) {
            System.out.println(sobremesa.toString());
        }
        for (Bebida bebida : bebidas) {
            System.out.println(bebida.toString());
        }
    }
}
