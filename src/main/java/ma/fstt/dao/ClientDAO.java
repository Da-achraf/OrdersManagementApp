package ma.fstt.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import ma.fstt.entities.Client;
import ma.fstt.entities.Command;
import ma.fstt.service.ClientRepository;

@ApplicationScoped
public class ClientDAO implements ClientRepository {

    protected String query = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected Connection cnx;

    public ClientDAO() throws ClassNotFoundException, SQLException {
        cnx = ConnectionJDBC.getInstance();
    }

    @Override
    public Client findById(String id) throws SQLException {
        query = "SELECT * FROM client where id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, id);
        resultSet = preparedStatement.executeQuery();

        Client client = new Client();
        while (resultSet.next()) {
            client = new Client(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        }

        return client;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        query = "SELECT * FROM client";

        preparedStatement = cnx.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        List<Client> clientList = new ArrayList<>();
        while (resultSet.next()) {
            clientList.add(new Client(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
        }

        return clientList;
    }

    @Override
    public void addClient(Client client) throws SQLException {
        query = "INSERT INTO client(name, address, phone) VALUES(?, ?, ?)";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getAddress());
        preparedStatement.setString(3, client.getPhone());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        query = "UPDATE client SET name=?, address=?, phone=? WHERE id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getAddress());
        preparedStatement.setString(3, client.getPhone());
        preparedStatement.setString(4, client.getId().toString());
        preparedStatement.executeUpdate();
    }



    @Override
    public void deleteClient(String id) throws SQLException {
        query = "DELETE FROM client WHERE id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Command> findAllCommands(String id) throws SQLException {
        query = "SELECT * FROM command WHERE client_id=?";

        preparedStatement = cnx.prepareStatement(query);
        preparedStatement.setString(1, id);
        resultSet = preparedStatement.executeQuery();

        List<Command> commands = new ArrayList<>();
        while (resultSet.next()) {
            commands.add(new Command(resultSet.getLong(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5)));
        }

        return commands;
    }


}