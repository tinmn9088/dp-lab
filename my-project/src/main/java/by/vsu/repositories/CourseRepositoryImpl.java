package by.vsu.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import by.vsu.models.Course;
import by.vsu.util.ConfigProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    private final static String URL = ConfigProvider.getValue("db.url");

    private final static String USER = ConfigProvider.getValue("db.user");
    
    private final static String PASSWORD = ConfigProvider.getValue("db.password");

    private TeacherRepository teacherRepository;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }
    
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, teacher_id, title, speciality, semester, number_of_students, hours_of_lectures, hours_of_practice, hours_of_lab, exam FROM courses");  
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getLong(1));
                course.setTeacher(teacherRepository.getTeacherById(rs.getLong(2)));
                course.setTitle(rs.getString(3));
                course.setSpeciality(rs.getString(4));
                course.setSemester(rs.getInt(5));
                course.setNumberOfStudents(rs.getInt(6));
                course.setHoursOfLectures(rs.getInt(7));
                course.setHoursOfPractice(rs.getInt(8));
                course.setHoursOfLaboratoryWork(rs.getInt(9));
                course.setExam(rs.getBoolean(10));
                courses.add(course);
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
        return courses;
    }

    @Override
    public Course getCourseById(long id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, teacher_id, title, speciality, semester, number_of_students, hours_of_lectures, hours_of_practice, hours_of_lab, exam FROM courses");  
            if (rs.next()) {
                Course course = new Course();
                course.setId(rs.getLong(1));
                course.setTeacher(teacherRepository.getTeacherById(rs.getLong(2)));
                course.setTitle(rs.getString(3));
                course.setSpeciality(rs.getString(4));
                course.setSemester(rs.getInt(5));
                course.setNumberOfStudents(rs.getInt(6));
                course.setHoursOfLectures(rs.getInt(7));
                course.setHoursOfPractice(rs.getInt(8));
                course.setHoursOfLaboratoryWork(rs.getInt(9));
                course.setExam(rs.getBoolean(10));
                return course;
            } else {
                return null;
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
    }
}
