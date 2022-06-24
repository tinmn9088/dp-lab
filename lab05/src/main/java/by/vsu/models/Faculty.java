package by.vsu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String phone;

    private String deanFName;

    private String deanLName;

    private String deanPatronymic;
}
