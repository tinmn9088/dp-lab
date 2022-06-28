package by.vsu.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.vsu.models.User;
import by.vsu.services.UserService;
import by.vsu.util.ServiceProvider;

public class LoginServlet extends HttpServlet {

    private UserService userService = ServiceProvider.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null) {
            User user = userService.getUserByLoginPassword(login, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("teachers");
            } else {
                String message = "Неверный логин или пароль";
                resp.sendRedirect("login?message=" + URLEncoder.encode(message, "UTF-8"));
            }
        }
    }
}