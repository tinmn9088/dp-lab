package by.vsu.util;

import by.vsu.repositories.CourseRepository;
import by.vsu.repositories.CourseRepositoryImpl;
import by.vsu.repositories.TeacherRepository;
import by.vsu.repositories.TeacherRepositoryImpl;

public class RepositoryProvider {
    
    private static TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    
    private static CourseRepository courseRepository = new CourseRepositoryImpl(teacherRepository);

    public static TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }

    public static CourseRepository getCourseRepository() {
        return courseRepository;
    }
}
