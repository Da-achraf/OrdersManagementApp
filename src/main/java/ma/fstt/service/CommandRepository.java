package ma.fstt.service;

import ma.fstt.entities.Client;
import ma.fstt.entities.Command;

import java.sql.SQLException;
import java.util.List;

public interface CommandRepository {

    Command findById(String id) throws SQLException;

    List<Command> findAll() throws SQLException;

    void add(Command command) throws SQLException;

    void update(Command command) throws SQLException;

    void delete(String id) throws SQLException;

}
