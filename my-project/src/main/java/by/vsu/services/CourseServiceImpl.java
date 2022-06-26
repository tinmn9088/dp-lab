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
}
