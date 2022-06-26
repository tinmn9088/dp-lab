package by.vsu.dao;

import java.util.List;

import by.vsu.models.Course;

public interface CourseDao {
    
    List<Course> getAllCourses();

    Course getCourseById(long id);

    List<Course> getCoursesByTeacherId(long teacherId);

    void addCourse(Course newCourse);
}
