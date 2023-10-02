package ma.fstt.servlet.client;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;


@WebServlet(name = "clientListServlet", value = "/client/list", loadOnStartup = 1)
public class ClientListServlet extends HttpServlet {

    @Inject
    private ClientDAO clientDAO;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Client> clientList = new ArrayList<>();

		try {
			clientList = clientDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        request.setAttribute("clients", clientList);
        request.getRequestDispatcher("/client/list/list.jsp").forward(request, response);
    }

    public void destroy() {
    }
}