package by.vsu.util;

import by.vsu.dao.CourseDao;
import by.vsu.dao.CourseDaoImpl;
import by.vsu.dao.TeacherDao;
import by.vsu.dao.TeacherDaoImpl;

public class DaoProvider {
    
    private static TeacherDao teacherDao = new TeacherDaoImpl(RepositoryProvider.getTeacherRepository());

    private static CourseDao courseDao = new CourseDaoImpl(RepositoryProvider.getCourseRepository());

    public static TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public static CourseDao getCourseDao() {
        return courseDao;
    }
}
