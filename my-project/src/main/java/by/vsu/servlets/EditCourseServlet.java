package by.vsu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.models.Course;
import by.vsu.services.CourseService;
import by.vsu.services.TeacherService;
import by.vsu.util.ServiceProvider;

public class EditCourseServlet extends HttpServlet {

    private TeacherService teacherService = ServiceProvider.getTeacherService();

    private CourseService courseService = ServiceProvider.getCourseService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            try {
                Course existingCourse = courseService.getCourseById(Long.parseLong(id));
                req.setAttribute("course", existingCourse);
            } catch (NumberFormatException ignored) {}
        }
        req.setAttribute("teachers", teacherService.getAllTeachers());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/courses/edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Course newCourse = new Course();
        String teacher = req.getParameter("teacher");
        try {
            newCourse.setTeacher(teacherService.getTeacherById(
                    Long.parseLong(teacher.substring(0, teacher.indexOf(".")))));
        } catch (NumberFormatException ignored) {}
        newCourse.setTitle(req.getParameter("title"));
        long id = courseService.addCourse(newCourse); 
        resp.sendRedirect("edit?id=" + id);
    }
}
