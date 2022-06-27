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
        Course course = new Course();
        String teacher = req.getParameter("teacher");
        if (teacher != null) {
            try {
                course.setTeacher(teacherService.getTeacherById(
                        Long.parseLong(teacher.substring(0, teacher.indexOf(".")))));
            } catch (NumberFormatException ignored) {}
        }
        course.setTitle(req.getParameter("title"));
        course.setSpeciality(req.getParameter("speciality"));
        try {
            course.setSemester(Integer.parseInt(req.getParameter("semester")));
        } catch (NumberFormatException ignored) {}
        try {
            course.setNumberOfStudents(Integer.parseInt(req.getParameter("numberOfStudents")));
        } catch (NumberFormatException ignored) {}
        try {
            course.setHoursOfLectures(Integer.parseInt(req.getParameter("hoursOfLectures")));
        } catch (NumberFormatException ignored) {}
        try {
            course.setHoursOfPractice(Integer.parseInt(req.getParameter("hoursOfPractice")));
        } catch (NumberFormatException ignored) {}
        try {
            course.setHoursOfLaboratoryWork(Integer.parseInt(req.getParameter("hoursOfLab")));
        } catch (NumberFormatException ignored) {}
        course.setExam(req.getParameter("exam") != null);
        try {
            course.setNumberOfTests(Integer.parseInt(req.getParameter("numberOfTests")));
        } catch (NumberFormatException ignored) {}

        if (req.getParameter("id") == null) {
            long id = courseService.addCourse(course); 
            resp.sendRedirect("edit?id=" + id);
        } else {
            try {
                course.setId(Long.parseLong(req.getParameter("id")));
                courseService.updateCourse(course); 
                resp.sendRedirect("edit?id=" + req.getParameter("id"));
            } catch (NumberFormatException ignored) {}
        }
    }
}
