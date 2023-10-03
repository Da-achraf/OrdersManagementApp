package ma.fstt.servlet.command;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "addCommandFormServlet", value = "/command/add_form")
public class AddCommandFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String clientId = request.getParameter("id");
        request.setAttribute("clientId", clientId);
        request.getRequestDispatcher("/command/add/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}