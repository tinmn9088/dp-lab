package by.vsu.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
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
            Statement stmt = con.createStatement();  
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
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, teacher_id, title, speciality, semester, number_of_students, hours_of_lectures, hours_of_practice, hours_of_lab, exam FROM courses WHERE id = '" + id + "'");  
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

    @Override
    public List<Course> getCoursesByTeacherId(long teacherId) {
        List<Course> courses = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, teacher_id, title, speciality, semester, number_of_students, hours_of_lectures, hours_of_practice, hours_of_lab, exam FROM courses WHERE teacher_id = '" + teacherId + "'");  
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
    public long addCourse(Course newCourse) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            PreparedStatement stmt = con.prepareStatement("INSERT INTO courses (teacher_id, title, speciality, semester, number_of_students, hours_of_lectures, hours_of_practice, hours_of_lab, exam) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
            if (newCourse.getTeacher() != null) {
                stmt.setLong(1, newCourse.getTeacher().getId());
            } else {
                stmt.setNull(1, Types.BIGINT);
            }
            if (newCourse.getTitle() != null) {
                stmt.setString(2, newCourse.getTitle());
            } else {
                stmt.setNull(2, Types.NVARCHAR);
            }
            if (newCourse.getSpeciality() != null) {
                stmt.setString(3, newCourse.getSpeciality());
            } else {
                stmt.setNull(3, Types.NVARCHAR);
            }
            stmt.setInt(4, newCourse.getSemester());
            stmt.setInt(5, newCourse.getNumberOfStudents());
            stmt.setInt(6, newCourse.getHoursOfLectures());
            stmt.setInt(7, newCourse.getHoursOfPractice());
            stmt.setInt(8, newCourse.getHoursOfLaboratoryWork());
            stmt.setBoolean(9, newCourse.isExam());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
    }

    @Override
    public void updateCourse(Course course) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            PreparedStatement stmt = con.prepareStatement("UPDATE courses SET teacher_id = ?, title = ?, speciality = ?, semester = ?, number_of_students = ?, hours_of_lectures = ?, hours_of_practice = ?, hours_of_lab = ?, exam = ? WHERE id = ?");
            if (course.getTeacher() != null) {
                stmt.setLong(1, course.getTeacher().getId());
            } else {
                stmt.setNull(1, Types.BIGINT);
            }
            if (course.getTitle() != null) {
                stmt.setString(2, course.getTitle());
            } else {
                stmt.setNull(2, Types.NVARCHAR);
            }
            if (course.getSpeciality() != null) {
                stmt.setString(3, course.getSpeciality());
            } else {
                stmt.setNull(3, Types.NVARCHAR);
            }
            stmt.setInt(4, course.getSemester());
            stmt.setInt(5, course.getNumberOfStudents());
            stmt.setInt(6, course.getHoursOfLectures());
            stmt.setInt(7, course.getHoursOfPractice());
            stmt.setInt(8, course.getHoursOfLaboratoryWork());
            stmt.setBoolean(9, course.isExam());
            stmt.setLong(10, course.getId());
            stmt.executeUpdate();
            System.out.println(stmt);
            System.out.println(course);
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
    }

    @Override
    public void deleteCourse(long id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt = con.createStatement();  
            stmt.executeUpdate("DELETE FROM courses WHERE id = '" + id + "'");  
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
    }
}
