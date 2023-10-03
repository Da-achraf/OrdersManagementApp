package ma.fstt.servlet.command;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "commandListServlet", value = "/command/list", loadOnStartup = 1)
public class CommandListServlet extends HttpServlet {

    @Inject
    private ClientDAO clientDAO;
    @Inject
    private CommandDAO commandDAO;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String clientId = request.getParameter("id");
        List<Command> commands;
        List<Client> clients;

        if (clientId == null || clientId.isEmpty()) {
            try {
                commands = commandDAO.findAll();
                clients = clientDAO.findAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                commands = clientDAO.findAllCommands(clientId);
                clients = clientDAO.findAll();
                Client client = clientDAO.findById(clientId);
                request.setAttribute("client", client);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        request.setAttribute("commands", commands);
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/command/list/list.jsp").forward(request, response);
    }

    public void destroy() {
    }
}