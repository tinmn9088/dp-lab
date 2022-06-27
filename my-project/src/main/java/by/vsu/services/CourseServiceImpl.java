package by.vsu.services;

import java.util.List;

import by.vsu.dao.CourseDao;
import by.vsu.models.Course;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;
    
    @Override
    public List<Course> getAllCourses() {
        try {
            return courseDao.getAllCourses();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Course getCourseById(long id) {
        try {
            return courseDao.getCourseById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Course> getCoursesByTeacherId(long teacherId) {
        try {
            return courseDao.getCoursesByTeacherId(teacherId);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public long addCourse(Course newCourse) {
        try {
            return courseDao.addCourse(newCourse);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void updateCourse(Course course) {
        try {
            courseDao.updateCourse(course);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void deleteCourse(long id) {
        try {
            courseDao.deleteCourse(id);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }
}
