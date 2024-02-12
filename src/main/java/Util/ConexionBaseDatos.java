package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Julián <Julián at Google>
 */
public class ConexionBaseDatos {
    private static String url="jdbc:mysql://localhost:3306/universidad_proyecto";
    private static String username="root";
    private static String password="JDPerez1005";
    private static Connection conection;

    private ConexionBaseDatos(){
        
    }

    public static Connection getInstance()throws SQLException{
        if(conection==null){
            conection=DriverManager.getConnection(url,username,password);       
        }
        return conection;
    }
}
