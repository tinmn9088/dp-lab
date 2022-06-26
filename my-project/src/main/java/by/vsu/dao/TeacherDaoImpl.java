package by.vsu.dao;

import java.util.List;

import by.vsu.models.Teacher;
import by.vsu.repositories.TeacherRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeacherDaoImpl implements TeacherDao {

    private TeacherRepository teacherRepository;
    
    @Override
    public List<Teacher> getAllTeachers() {
        try {
            return teacherRepository.getAllTeachers();
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Teacher getTeacherById(long id) {
        try {
            return teacherRepository.getTeacherById(id);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }
}
