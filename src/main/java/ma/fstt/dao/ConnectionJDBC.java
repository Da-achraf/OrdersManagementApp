package ma.fstt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private final static String url ="jdbc:mysql://localhost/orders?autoReconnect=true&useSSL=false";
    private final static String user ="root";
    private final static String password ="";

    private static Connection cnx;

    private ConnectionJDBC() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        cnx = DriverManager.getConnection(url , user ,password );
        System.out.println("Connection created");

    }

    public static Connection getInstance() throws SQLException, ClassNotFoundException {

        if(cnx == null){
            new ConnectionJDBC();
        }

        return cnx ;

    }
}
