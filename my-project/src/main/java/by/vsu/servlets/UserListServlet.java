package by.vsu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.models.User;
import by.vsu.services.UserService;
import by.vsu.util.ServiceProvider;

public class UserListServlet extends HttpServlet {

    private UserService userService = ServiceProvider.getUserService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/users/list.jsp")
                .forward(req, resp);
    }
}
