package by.vsu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class Enrollee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String fname;

    private String lname;

    private String patronymic;

    private Speciality speciality;
}
