package by.vsu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.services.UserService;
import by.vsu.util.ServiceProvider;

public class DeleteUserServlet extends HttpServlet {
    
    private UserService userService = ServiceProvider.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            try {
                userService.deleteUser(Long.parseLong(id));
            } catch (NumberFormatException ignored) {}
        }
        resp.sendRedirect("../users");
    }
}
