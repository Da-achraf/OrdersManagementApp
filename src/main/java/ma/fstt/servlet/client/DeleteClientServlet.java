package ma.fstt.servlet.client;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.fstt.dao.ClientDAO;

import java.io.IOException;
import java.sql.SQLException;

    @WebServlet(name = "DeleteClientServlet", value = "/client/delete")
public class DeleteClientServlet extends HttpServlet {

    private @Inject ClientDAO clientDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            clientDAO.deleteClient(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}