package by.vsu.dao;

import java.util.List;

import by.vsu.models.Teacher;

public interface TeacherDao {
    
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(long id);

    long addTeacher(Teacher newTeacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(long id);
}
