package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mauricio on 14/05/17.
 */
public class Conexao {

    private Connection connection;
    private Statement statement;

    public Connection open(){
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/disck_rango",
                    "root", "mauricio");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public void close(){
        try {
            if(statement != null){
                statement.close();
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
