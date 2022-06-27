package by.vsu.util;

import by.vsu.services.CourseService;
import by.vsu.services.CourseServiceImpl;
import by.vsu.services.TeacherService;
import by.vsu.services.TeacherServiceImpl;
import by.vsu.services.UserService;
import by.vsu.services.UserServiceImpl;

public class ServiceProvider {
    
    private static TeacherService teacherService = new TeacherServiceImpl(DaoProvider.getTeacherDao());

    private static CourseService courseService = new CourseServiceImpl(DaoProvider.getCourseDao());

    private static UserService userService = new UserServiceImpl(DaoProvider.getUserDao());

    public static TeacherService getTeacherService() {
        return teacherService;
    }

    public static CourseService getCourseService() {
        return courseService;
    }

    public static UserService getUserService() {
        return userService;
    }
}
