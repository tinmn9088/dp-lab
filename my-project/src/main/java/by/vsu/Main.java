package by.vsu;

import java.io.File;
import java.util.List;

import by.vsu.models.Course;
import by.vsu.models.Teacher;
import by.vsu.repositories.CourseRepositoryImpl;
import by.vsu.repositories.TeacherRepositoryImpl;


public class Main {
    
    public static void main(String[] args) throws Exception {
        System.out.println(new File(".").getAbsolutePath());
        List<Teacher> teachers = new TeacherRepositoryImpl().getAllTeachers();
        System.out.println(teachers.get(0));
        System.out.println(new TeacherRepositoryImpl().getTeacherById(1));
        System.out.println(new TeacherRepositoryImpl().getTeacherById(2));

        List<Course> courses = new CourseRepositoryImpl(new TeacherRepositoryImpl()).getAllCourses();
        System.out.println(courses);
        System.out.println(new CourseRepositoryImpl(new TeacherRepositoryImpl()).getCourseById(1));
    }
}
