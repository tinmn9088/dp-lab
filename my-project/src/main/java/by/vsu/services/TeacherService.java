package by.vsu.services;

import java.util.List;

import by.vsu.models.Teacher;

public interface TeacherService {
    
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(long id);

    long addTeacher(Teacher newTeacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(long id);
}
