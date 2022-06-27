package by.vsu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.services.TeacherService;
import by.vsu.util.ServiceProvider;

public class DeleteTeacherServlet extends HttpServlet {
    
    private TeacherService teacherService = ServiceProvider.getTeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            try {
                teacherService.deleteTeacher(Long.parseLong(id));
            } catch (NumberFormatException ignored) {}
        }
        resp.sendRedirect("../teachers");
    }
}
