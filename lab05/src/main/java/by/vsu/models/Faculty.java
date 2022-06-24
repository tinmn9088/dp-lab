package by.vsu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Faculty {

    private String id;

    private String name;

    private String phone;

    private String deanFName;

    private String deanLName;

    private String deanPatronymic;
}
