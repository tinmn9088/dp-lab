package by.vsu.util;

import by.vsu.services.CourseService;
import by.vsu.services.CourseServiceImpl;
import by.vsu.services.TeacherService;
import by.vsu.services.TeacherServiceImpl;

public class ServiceProvider {
    
    private static TeacherService teacherService = new TeacherServiceImpl(DaoProvider.getTeacherDao());

    private static CourseService courseService = new CourseServiceImpl(DaoProvider.getCourseDao());

    public static TeacherService getTeacherService() {
        return teacherService;
    }

    public static CourseService getCourseService() {
        return courseService;
    }
}
