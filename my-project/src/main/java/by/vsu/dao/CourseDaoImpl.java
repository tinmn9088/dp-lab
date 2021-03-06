package by.vsu.dao;

import java.util.List;

import by.vsu.models.Course;
import by.vsu.repositories.CourseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private CourseRepository courseRepository;
    
    @Override
    public List<Course> getAllCourses() {
        try {
            return courseRepository.getAllCourses();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Course getCourseById(long id) {
        try {
            return courseRepository.getCourseById(id);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Course> getCoursesByTeacherId(long teacherId) {
        try {
            return courseRepository.getCoursesByTeacherId(teacherId);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public long addCourse(Course newCourse) {
        try {
            return courseRepository.addCourse(newCourse);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void updateCourse(Course course) {
        try {
            courseRepository.updateCourse(course);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteCourse(long id) {
        try {
            courseRepository.deleteCourse(id);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
