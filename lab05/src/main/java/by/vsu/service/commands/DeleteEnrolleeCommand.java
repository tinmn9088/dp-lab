package by.vsu.service.commands;

import by.vsu.controller.processors.DataChange;
import by.vsu.models.Enrollee;
import by.vsu.models.Speciality;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteEnrolleeCommand extends Command implements DataChange {

    @NonNull
    private String enrolleeId;

    private Enrollee enrolleeToDelete;

    @Override
    public void run() {
        enrolleeToDelete = getEnrolleeDao().getEnrolleeById(enrolleeId);
        if (enrolleeToDelete == null) {
            throw new IllegalArgumentException("Абитериент " + enrolleeId + " не существует");
        }
        getEnrolleeDao().deleteEnrollee(enrolleeId);
    }

    @Override
    public void undo() {
        getEnrolleeDao().addEnrollee(enrolleeToDelete);
    }

    @Override
    public String getMessage() {
        return (enrolleeToDelete != null) ? "Удалить студента " + enrolleeToDelete.getId() : null;
    }
}
