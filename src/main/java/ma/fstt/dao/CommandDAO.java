package ma.fstt.dao;

import jakarta.enterprise.context.ApplicationScoped;
import ma.fstt.entities.Client;
import ma.fstt.entities.Command;
import ma.fstt.service.ClientRepository;
import ma.fstt.service.CommandRepository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CommandDAO implements CommandRepository {

    protected String query = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected Connection cnx;

    public CommandDAO() throws ClassNotFoundException, SQLException {
        cnx = ConnectionJDBC.getInstance();
    }

    @Override
    public Command findById(String id) throws SQLException {
        query = "SELECT * FROM command where id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, id);
        resultSet = preparedStatement.executeQuery();

        Command command = new Command();
        while (resultSet.next()) {
            command = new Command(resultSet.getLong(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5));
        }

        return command;
    }

    @Override
    public List<Command> findAll() throws SQLException {
        query = "SELECT * FROM command";

        preparedStatement = cnx.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        List<Command> commands = new ArrayList<>();
        while (resultSet.next()) {
            commands.add(new Command(resultSet.getLong(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5)));
        }

        return commands;
    }

    @Override
    public void add(Command command) throws SQLException {
        query = "INSERT INTO command(label, date, status, deliveryAddr, client_id) VALUES(?, ?, ?, ?, ?)";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, command.getLabel());
        preparedStatement.setDate(2, command.getDate());
        preparedStatement.setString(3, command.getStatus());
        preparedStatement.setString(4, command.getDeliveryAddr());
        preparedStatement.setString(5, String.valueOf(command.getClient().getId()));
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Command command) throws SQLException {
        query = "UPDATE command SET label=?, date=?, status=?, deliveryAddr=? WHERE id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, command.getLabel());
        preparedStatement.setDate(2, command.getDate());
        preparedStatement.setString(3, command.getStatus());
        preparedStatement.setString(4, command.getDeliveryAddr());
        preparedStatement.setInt(5, Math.toIntExact(command.getId()));
        preparedStatement.executeUpdate();
    }


    @Override
    public void delete(String id) throws SQLException {
        query = "DELETE FROM command WHERE id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

}