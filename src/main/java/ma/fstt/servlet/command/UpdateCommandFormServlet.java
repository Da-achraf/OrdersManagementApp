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

// This servlet returns the form to update a client
@WebServlet(name = "updateCommandFormServlet", value = "/command/update_form")
public class UpdateCommandFormServlet extends HttpServlet {

    @Inject
    CommandDAO commandDAO;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Command command;
        try {
            command = commandDAO.findById(id);
            request.setAttribute("command", command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/command/update/update.jsp").forward(request, response);
    }

    public void destroy() {
    }
}