package by.vsu.util;

import by.vsu.repositories.CourseRepository;
import by.vsu.repositories.CourseRepositoryImpl;
import by.vsu.repositories.TeacherRepository;
import by.vsu.repositories.TeacherRepositoryImpl;
import by.vsu.repositories.UserRepository;
import by.vsu.repositories.UserRepositoryImpl;

public class RepositoryProvider {
    
    private static TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    
    private static CourseRepository courseRepository = new CourseRepositoryImpl(teacherRepository);

    private static UserRepository userRepository = new UserRepositoryImpl();

    public static TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }

    public static CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }
}
