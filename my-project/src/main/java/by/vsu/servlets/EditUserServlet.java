package by.vsu.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.models.User;
import by.vsu.services.UserService;
import by.vsu.util.ServiceProvider;

public class EditUserServlet extends HttpServlet {

    private UserService userService = ServiceProvider.getUserService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            try {
                User existingUser = userService.getUserById(Long.parseLong(id));
                req.setAttribute("user", existingUser);
            } catch (NumberFormatException ignored) {}
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/users/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        if (req.getParameter("roles") != null) {
            Set<String> roles = new HashSet<>(List.of(req.getParameter("roles").split(",")));
            user.setRoles(roles);
        }
        
        if (req.getParameter("id") == null) {
            long id = userService.addUser(user); 
            resp.sendRedirect("edit?id=" + id);
        } else {
            try {
                user.setId(Long.parseLong(req.getParameter("id")));
                userService.updateUser(user);
                resp.sendRedirect("edit?id=" + req.getParameter("id"));
            } catch (NumberFormatException ignored) {}
        }
    }
}
