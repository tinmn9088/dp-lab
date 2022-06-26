package by.vsu.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import by.vsu.models.Teacher;
import by.vsu.util.ConfigProvider;

public class TeacherRepositoryImpl implements TeacherRepository {

    private final static String URL = ConfigProvider.getValue("db.url");

    private final static String USER = ConfigProvider.getValue("db.user");
    
    private final static String PASSWORD = ConfigProvider.getValue("db.password");
    
    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new LinkedList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, lname, fname, patronymic, degree, place, gender, birthdate FROM teachers");  
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong(1));
                teacher.setLname(rs.getString(2));
                teacher.setFname(rs.getString(3));
                teacher.setPatronymic(rs.getString(4));
                teacher.setDegree(rs.getString(5));
                teacher.setPlace(rs.getString(6));
                teacher.setGender(rs.getString(7));
                teacher.setBirthdate(rs.getDate(8).toLocalDate());
                teachers.add(teacher);
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }  
        return teachers;
    }

    @Override
    public Teacher getTeacherById(long id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            Statement stmt= con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT id, lname, fname, patronymic, degree, place, gender, birthdate FROM teachers WHERE id=" + id);  
            if (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong(1));
                teacher.setLname(rs.getString(2));
                teacher.setFname(rs.getString(3));
                teacher.setPatronymic(rs.getString(4));
                teacher.setDegree(rs.getString(5));
                teacher.setPlace(rs.getString(6));
                teacher.setGender(rs.getString(7));
                teacher.setBirthdate(rs.getDate(8).toLocalDate());
                return teacher;
            } else {
                return null;
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }
}
