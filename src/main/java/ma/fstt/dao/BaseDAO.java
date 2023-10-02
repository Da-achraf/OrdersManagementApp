package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
    protected String query = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected Connection cnx;

    public BaseDAO() throws ClassNotFoundException, SQLException {
        cnx = ConnectionJDBC.getInstance();
    }
}
