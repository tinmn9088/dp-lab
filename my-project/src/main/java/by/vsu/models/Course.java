package by.vsu.models;

import lombok.Data;

@Data
public class Course {

    private long id;
    
    private Teacher teacher;

    private String title;

    private String speciality;

    private int semester;

    private int numberOfStudents;

    private int hoursOfLectures;

    private int hoursOfPractice;

    private int hoursOfLaboratoryWork;

    private boolean exam;

    private int numberOfTests;

    public int getCourse() {
        return (int) Math.ceil(((double) getSemester()) / 2);
    }

    public int getHours() {
        double result = getHoursOfLectures() + getHoursOfPractice() + getHoursOfLaboratoryWork();
        result += getHoursOfLectures() * 0.05;
        result += 2;
        if (exam) {
            result += getNumberOfStudents() * 0.5;
        } else {
            result += getNumberOfStudents() * 0.25;
        }
        result += getNumberOfTests() * getNumberOfStudents() * 0.15;
        return (int) Math.ceil(result);
    }
}
