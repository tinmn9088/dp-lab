package by.vsu.repositories;

import java.util.List;

import by.vsu.models.Teacher;

public interface TeacherRepository {
    
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(long id);
}
