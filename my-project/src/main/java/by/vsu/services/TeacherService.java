package by.vsu.services;

import java.util.List;

import by.vsu.models.Teacher;

public interface TeacherService {
    
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(long id);
}
