package by.vsu.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import by.vsu.models.Teacher;
import by.vsu.util.ConfigProvider;

public class TeacherRepositoryImpl implements TeacherRepository {

    private final static String URL = ConfigProvider.getValue("db.url");

    private final static String USER = ConfigProvider.getValue("db.user");
    
    private final static String PASSWORD = ConfigProvider.getValue("db.password");

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }
    
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
                teacher.setBirthdate((rs.getDate(8) != null) ? rs.getDate(8).toLocalDate() : null);
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
                teacher.setBirthdate((rs.getDate(8) != null) ? rs.getDate(8).toLocalDate() : null);
                return teacher;
            } else {
                return null;
            }
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }

    @Override
    public long addTeacher(Teacher newTeacher) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            PreparedStatement stmt = con.prepareStatement("INSERT INTO teachers (fname, lname, patronymic, degree, place, gender, birthdate) VALUES (?, ?, ?, ?, ?, ?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);
            if (newTeacher.getFname() != null) {
                stmt.setString(1, newTeacher.getFname());
            } else {
                stmt.setNull(1, Types.NVARCHAR);
            }
            if (newTeacher.getLname() != null) {
                stmt.setString(2, newTeacher.getLname());
            } else {
                stmt.setNull(2, Types.NVARCHAR);
            }
            if (newTeacher.getPatronymic() != null) {
                stmt.setString(3, newTeacher.getPatronymic());
            } else {
                stmt.setNull(3, Types.NVARCHAR);
            }
            if (newTeacher.getDegree() != null) {
                stmt.setString(4, newTeacher.getDegree());
            } else {
                stmt.setNull(4, Types.NVARCHAR);
            }
            if (newTeacher.getPlace() != null) {
                stmt.setString(5, newTeacher.getPlace());
            } else {
                stmt.setNull(5, Types.NVARCHAR);
            }
            if (newTeacher.getGender() != null) {
                stmt.setString(6, newTeacher.getGender());
            } else {
                stmt.setNull(6, Types.NVARCHAR);
            }
            if (newTeacher.getBirthdate() != null) {
                stmt.setDate(7, Date.valueOf(newTeacher.getBirthdate()));
            } else {
                stmt.setNull(7, Types.DATE);
            }
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {  
            PreparedStatement stmt = con.prepareStatement("UPDATE teachers SET fname = ?, lname = ?, patronymic = ?, degree = ?, place = ?, gender = ?, birthdate = ? WHERE id = " + teacher.getId());
            if (teacher.getFname() != null) {
                stmt.setString(1, teacher.getFname());
            } else {
                stmt.setNull(1, Types.NVARCHAR);
            }
            if (teacher.getLname() != null) {
                stmt.setString(2, teacher.getLname());
            } else {
                stmt.setNull(2, Types.NVARCHAR);
            }
            if (teacher.getPatronymic() != null) {
                stmt.setString(3, teacher.getPatronymic());
            } else {
                stmt.setNull(3, Types.NVARCHAR);
            }
            if (teacher.getDegree() != null) {
                stmt.setString(4, teacher.getDegree());
            } else {
                stmt.setNull(4, Types.NVARCHAR);
            }
            if (teacher.getPlace() != null) {
                stmt.setString(5, teacher.getPlace());
            } else {
                stmt.setNull(5, Types.NVARCHAR);
            }
            if (teacher.getGender() != null) {
                stmt.setString(6, teacher.getGender());
            } else {
                stmt.setNull(6, Types.NVARCHAR);
            }
            if (teacher.getBirthdate() != null) {
                stmt.setDate(7, Date.valueOf(teacher.getBirthdate()));
            } else {
                stmt.setNull(7, Types.DATE);
            }
            stmt.executeUpdate();
        } catch (Exception e) { 
            throw new RepositoryException(e);
        }
    }

    @Override
    public void deleteTeacher(long id) {
        // TODO Auto-generated method stub
        
    }
}
