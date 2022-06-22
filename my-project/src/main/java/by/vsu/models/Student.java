package by.vsu.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
@SuppressWarnings("unused")
public class Student {

    @NonNull
    private String id;

    @NonNull
    private String group;

    @NonNull
    private String lname;

    @NonNull
    private String fname;

    @NonNull
    private String patronymic;

    @NonNull
    private int mark1;

    @NonNull
    private int mark2;

    @NonNull
    private int mark3;
    
    @NonNull
    private int mark4;

    private double avgMark;

    private String successfulInGroups;
}
