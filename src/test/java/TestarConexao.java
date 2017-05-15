import connection.Conexao;

import java.sql.SQLException;

/**
 * Created by mauricio on 15/05/17.
 */
public class TestarConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        conexao.open();
        System.out.println("Conexão estabelecida....");
        conexao.close();
    }
}
