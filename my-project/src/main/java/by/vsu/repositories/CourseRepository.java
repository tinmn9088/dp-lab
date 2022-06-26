package by.vsu.repositories;

import java.util.List;

import by.vsu.models.Course;

public interface CourseRepository {
    
    List<Course> getAllCourses();

    Course getCourseById(long id);
}
