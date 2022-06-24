package by.vsu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Speciality {

    private String id;

    private String cipher;

    private String name;

    private String qualification;

    private Faculty faculty;
}
