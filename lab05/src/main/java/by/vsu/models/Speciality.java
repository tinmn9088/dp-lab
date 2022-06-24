package by.vsu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class Speciality implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String cipher;

    private String name;

    private String qualification;

    private Faculty faculty;
}
