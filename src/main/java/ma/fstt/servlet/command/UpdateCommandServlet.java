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
import ma.fstt.utilities.Utilities;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;


// This servlet receives the post request of saving a new client
@WebServlet(name = "updateCommandServlet", value = "/command/update")
public class UpdateCommandServlet extends HttpServlet {

    @Inject
    CommandDAO commandDAO;

    public void init() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod()))
        {
            Map<String, String> paramMap = Utilities.getParams(request);
            Long commandId = Long.valueOf(paramMap.get("commandId"));
            String label = paramMap.get("label").trim();
            Date date = Date.valueOf(paramMap.get("date"));
            String status = paramMap.get("status");
            String deliveryAddr = paramMap.get("deliveryAddr").trim();


            try {
                Command command = new Command(commandId, label, date, status, deliveryAddr);
                commandDAO.update(command);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            response.sendRedirect("list");
        }
    }


    public void destroy() {
    }
}