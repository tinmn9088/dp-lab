package by.vsu.dao;

import by.vsu.models.Enrollee;
import by.vsu.models.Faculty;
import by.vsu.models.Speciality;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class EnrolleeDaoImpl implements EnrolleeDao, Serializable {

    private static final long serialVersionUID = 1L;

    private Set<Faculty> faculties = new HashSet();

    private Set<Speciality> specialities = new HashSet();

    private Set<Enrollee> enrollees = new HashSet();

    {
        Faculty fa = new Faculty(UUID.randomUUID().toString(), "ФА", "+123456789012", "Иван", "Иванов", "Иваныч");
        Faculty fb = new Faculty(UUID.randomUUID().toString(), "ФБ", "+123456789013", "Анна", "Смирнова", "Андреевна");
        faculties.add(fa);
        faculties.add(fb);

        Speciality s1 = new Speciality(UUID.randomUUID().toString(), "XX1", "С1", "Ква", fa);
        Speciality s2 = new Speciality(UUID.randomUUID().toString(), "XX2", "С2", "КваКва", fb);
        specialities.add(s1);
        specialities.add(s2);

        Enrollee e11 = new Enrollee(UUID.randomUUID().toString(), "Андрей", "Романов", "Дмитриевич", s1);
        Enrollee e12 = new Enrollee(UUID.randomUUID().toString(), "Дарья", "Иванов", "Андреевна", s1);
        Enrollee e13 = new Enrollee(UUID.randomUUID().toString(), "Алексей", "Петров", "Петрович", s1);
        Enrollee e21 = new Enrollee(UUID.randomUUID().toString(), "Никита", "Неверовский", "Антонович", s2);
        Enrollee e22 = new Enrollee(UUID.randomUUID().toString(), "Елена", "Жириновская", "Дмитриевна", s2);
        enrollees.add(e11);
        enrollees.add(e12);
        enrollees.add(e13);
        enrollees.add(e21);
        enrollees.add(e22);
    }

    @Override
    public Set<Enrollee> getAllEnrollees() {
        return new HashSet<>(enrollees);
    }

    @Override
    public Set<Speciality> getAllSpecialities() {
        return new HashSet<>(specialities);
    }

    @Override
    public Set<Faculty> getAllFaculties() {
        return new HashSet<>(faculties);
    }

    @Override
    public Enrollee getEnrolleeById(String enrolleeId) {
        return enrollees.stream().filter(e -> e.getId().equals(enrolleeId)).findFirst().orElse(null);
    }

    @Override
    public Speciality getSpecialityById(String specialityId) {
        return specialities.stream().filter(e -> e.getId().equals(specialityId)).findFirst().orElse(null);

    }

    @Override
    public Faculty getFacultyById(String facultyId) {
        return faculties.stream().filter(e -> e.getId().equals(facultyId)).findFirst().orElse(null);
    }

    @Override
    public void addEnrollee(Enrollee newEnrollee) {
        enrollees.add(requireNonNull(newEnrollee));
    }

    @Override
    public void addSpeciality(Speciality newSpeciality) {
        specialities.add(requireNonNull(newSpeciality));
    }

    @Override
    public void addFaculty(Faculty newFaculty) {
        faculties.add(requireNonNull(newFaculty));
    }

    @Override
    public void deleteEnrollee(String enrolleeId) {
        Enrollee enrolleeToDelete = getEnrolleeById(enrolleeId);
        if (enrolleeToDelete != null) {
            enrollees.remove(enrolleeToDelete);
        }
    }

    @Override
    public void deleteSpeciality(String specialityId) {
        Speciality specialityToDelete = getSpecialityById(specialityId);
        if (specialityToDelete != null) {
            specialities.remove(specialityToDelete);
        }
    }

    @Override
    public void deleteFaculty(String facultyId) {
        Faculty facultyToDelete = getFacultyById(facultyId);
        if (facultyToDelete != null) {
            faculties.remove(facultyToDelete);
        }
    }
}
