package by.vsu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.services.CourseService;
import by.vsu.util.ServiceProvider;

public class CourseListServlet extends HttpServlet {

    private CourseService courseService = ServiceProvider.getCourseService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String teacherIdString = req.getParameter("teacherId");
        if (teacherIdString != null) {
            try {
                long teacherId = Long.parseLong(teacherIdString);
                req.setAttribute("teacherId", teacherId);
                req.setAttribute("courses", courseService.getCoursesByTeacherId(teacherId));
            } catch (NumberFormatException ignored) {}
        } else {
            req.setAttribute("courses", courseService.getAllCourses());
        }        
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/courses/list.jsp")
                .forward(req, resp);
    }
}
