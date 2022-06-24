package by.vsu.service.commands;

import by.vsu.models.Enrollee;
import by.vsu.models.Speciality;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class AddEnrolleeCommand extends Command {

    @NonNull
    private String fname;

    @NonNull
    private String lname;

    @NonNull
    private String patronymic;

    @NonNull
    private String specialityId;

    private Enrollee newEnrollee;

    @Override
    public void run() {
        Speciality speciality = getEnrolleeDao().getSpecialityById(specialityId);
        newEnrollee = new Enrollee(UUID.randomUUID().toString(), fname, lname, patronymic, speciality);
        getEnrolleeDao().addEnrollee(newEnrollee);
    }

    @Override
    public void undo() {
        getEnrolleeDao().deleteEnrollee(newEnrollee.getId());
    }
}
