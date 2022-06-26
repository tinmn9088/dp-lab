package by.vsu.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Teacher {

    private long id;

    private String lname;

    private String fname;

    private String patronymic;

    private String degree;

    private String place;

    private String gender;

    private LocalDate birthdate;

    private int numberOfCourses;
}
