package by.vsu.services;

import java.util.List;

import by.vsu.models.Course;

public interface CourseService {
    
    List<Course> getAllCourses();

    Course getCourseById(long id);

    List<Course> getCoursesByTeacherId(long teacherId);
}
