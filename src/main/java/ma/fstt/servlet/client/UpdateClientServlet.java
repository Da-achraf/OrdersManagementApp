package ma.fstt.servlet.client;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;
import ma.fstt.utilities.Utilities;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


// This servlet receives the post request of saving a new client
@WebServlet(name = "updateClientServlet", value = "/client/update")
public class UpdateClientServlet extends HttpServlet {

    @Inject
    ClientDAO clientDAO;

    public void init() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod()))
        {
            Map<String, String> paramMap = Utilities.getParams(request);
            Long id = Long.valueOf(paramMap.get("id").trim());
            String name = paramMap.get("name").trim();
            String address = paramMap.get("address").trim();
            String phone = paramMap.get("phone").trim();

            try {
                clientDAO.updateClient(new Client(id, name, address, phone));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("list");
        }
    }

//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if ("PUT".equalsIgnoreCase(request.getMethod()))
//        {
//            Map<String, String> paramMap = Utilities.getParams(request);
//            Long id = Long.valueOf(paramMap.get("id").trim());
//            String name = paramMap.get("name").trim();
//            String address = paramMap.get("address").trim();
//            String phone = paramMap.get("phone").trim();
//
//            try {
//                clientDAO.updateClient(new Client(id, name, address, phone));
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            response.sendRedirect("list");
//        }
//    }

    public void destroy() {
    }
}