package by.vsu.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.models.Teacher;
import by.vsu.services.TeacherService;
import by.vsu.util.ServiceProvider;

public class TeacherListServlet extends HttpServlet {

    private TeacherService teacherService = ServiceProvider.getTeacherService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Teacher> teachers = teacherService.getAllTeachers();
        req.setAttribute("teachers", teachers);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/teachers.jsp")
                .forward(req, resp);
    }
}
