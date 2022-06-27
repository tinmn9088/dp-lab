package by.vsu.services;

import java.util.List;

import by.vsu.dao.TeacherDao;
import by.vsu.models.Teacher;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;
    
    @Override
    public List<Teacher> getAllTeachers() {
        try {
            return teacherDao.getAllTeachers();
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Teacher getTeacherById(long id) {
        try {
            return teacherDao.getTeacherById(id);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public long addTeacher(Teacher newTeacher) {
        try {
            return teacherDao.addTeacher(newTeacher);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try {
            teacherDao.updateTeacher(teacher);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void deleteTeacher(long id) {
        try {
            teacherDao.deleteTeacher(id);
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }
}
