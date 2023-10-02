package ma.fstt.servlet.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// This servlet returns the form to add a client
@WebServlet(name = "addClientFormServlet", value = "/client/add_form")
public class AddClientFormServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/client/add/addClient.jsp").forward(request, response);
    }

    public void destroy() {
    }
}