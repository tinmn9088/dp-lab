package by.vsu.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.models.Course;
import by.vsu.models.Teacher;
import by.vsu.services.CourseService;
import by.vsu.services.TeacherService;
import by.vsu.util.ServiceProvider;

public class EditTeacherServlet extends HttpServlet {

    private TeacherService teacherService = ServiceProvider.getTeacherService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            try {
                Teacher existingTeacher = teacherService.getTeacherById(Long.parseLong(id));
                req.setAttribute("teacher", existingTeacher);
            } catch (NumberFormatException ignored) {}
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/teachers/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Teacher teacher = new Teacher();
        teacher.setFname(req.getParameter("fname"));
        teacher.setLname(req.getParameter("lname"));
        teacher.setPatronymic(req.getParameter("patronymic"));
        teacher.setDegree(req.getParameter("degree"));
        teacher.setPlace(req.getParameter("place"));
        teacher.setGender(req.getParameter("gender"));
        try {
            teacher.setBirthdate(LocalDate.parse(req.getParameter("birthdate")));
        } catch (DateTimeParseException ignored) {}
        
        if (req.getParameter("id") == null) {
            long id = teacherService.addTeacher(teacher); 
            resp.sendRedirect("edit?id=" + id);
        } else {
            try {
                teacher.setId(Long.parseLong(req.getParameter("id")));
                teacherService.updateTeacher(teacher); 
                resp.sendRedirect("edit?id=" + req.getParameter("id"));
            } catch (NumberFormatException ignored) {}
        }
    }
}
