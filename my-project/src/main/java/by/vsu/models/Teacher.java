package by.vsu.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
