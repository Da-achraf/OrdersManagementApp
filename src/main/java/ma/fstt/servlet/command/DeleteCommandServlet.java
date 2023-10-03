package ma.fstt.servlet.command;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteCommandServlet", value = "/command/delete")
public class DeleteCommandServlet extends HttpServlet {

private @Inject CommandDAO commandDAO;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    try {
        commandDAO.delete(id);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    response.sendRedirect("list");
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}
}