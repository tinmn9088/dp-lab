package by.vsu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Enrollee {

    private String id;

    private String fname;

    private String lname;

    private String patronymic;

    private Speciality speciality;
}
