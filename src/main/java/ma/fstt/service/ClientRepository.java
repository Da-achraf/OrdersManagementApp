package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Command;

public interface ClientRepository {

    Client findById(String id) throws SQLException;

    List<Client> findAll() throws SQLException;

    void addClient(Client client) throws SQLException;

    void updateClient(Client client) throws SQLException;

    void deleteClient(String id) throws SQLException;


    List<Command> findAllCommands(String id) throws SQLException;

}
