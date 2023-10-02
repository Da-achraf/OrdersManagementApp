package ma.fstt.servlet.client;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;
import ma.fstt.utilities.Utilities;


// This servlet receives the post request of saving a new client
@WebServlet(name = "addClientServlet", value = "/client/add")
public class AddClientServlet extends HttpServlet {

    @Inject
    ClientDAO clientDAO;

    public void init() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod()))
        {
            Map<String, String> paramMap = Utilities.getParams(request);
            String name = paramMap.get("name").trim();
            String address = paramMap.get("address").trim();
            String phone = paramMap.get("phone").trim();

            try {
                clientDAO.addClient(new Client(0L, name, address, phone));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("list");
        }
    }

    public void destroy() {
    }
}