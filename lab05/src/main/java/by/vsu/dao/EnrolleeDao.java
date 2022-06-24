package by.vsu.dao;

import by.vsu.models.Enrollee;
import by.vsu.models.Faculty;
import by.vsu.models.Speciality;

import java.util.Set;

public interface EnrolleeDao {

    Set<Enrollee> getAllEnrollees();

    Set<Speciality> getAllSpecialities();

    Set<Faculty> getAllFaculties();

    Enrollee getEnrolleeById(String enrolleeId);

    Speciality getSpecialityById(String specialityId);

    Faculty getFacultyById(String facultyId);

    void addEnrollee(Enrollee newEnrollee);

    void addSpeciality(Speciality newSpeciality);

    void addFaculty(Faculty newFaculty);

    void deleteEnrollee(String enrolleeId);

    void deleteSpeciality(String specialityId);

    void deleteFaculty(String facultyId);
}
