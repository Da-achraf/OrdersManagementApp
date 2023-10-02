package ma.fstt.servlet.client;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;

import java.io.IOException;
import java.sql.SQLException;

// This servlet returns the form to update a client
@WebServlet(name = "updateClientFormServlet", value = "/client/update_form")
public class UpdateClientFormServlet extends HttpServlet {

    @Inject
    ClientDAO clientDAO;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Client client;
        try {
            client = clientDAO.findById(id);
            request.setAttribute("client", client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/client/update/updateClient.jsp").forward(request, response);
    }

    public void destroy() {
    }
}