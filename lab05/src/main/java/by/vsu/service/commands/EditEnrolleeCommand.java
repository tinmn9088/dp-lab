package by.vsu.service.commands;

import by.vsu.controller.processors.DataChange;
import by.vsu.models.Enrollee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EditEnrolleeCommand extends Command implements DataChange {

    @NonNull
    private String enrolleeId;

    @NonNull
    Map<String, String> flags;

    private Enrollee enrollee;

    private Enrollee enrolleeBefore;

    @Override
    public void run() {
        enrollee = getEnrolleeDao().getEnrolleeById(enrolleeId);
        if (enrollee == null) {
            throw new IllegalArgumentException("Абитериент " + enrolleeId + " не существует");
        }
        enrolleeBefore = new Enrollee(enrollee.getId(), enrollee.getFname(), enrollee.getLname(), enrollee.getPatronymic(), enrollee.getSpeciality());

        for (Map.Entry<String, String> keyValue : flags.entrySet()) {
            switch (keyValue.getKey()) {
                case "fname":
                    enrollee.setFname(keyValue.getValue());
                    break;
                case "lname":
                    enrollee.setLname(keyValue.getValue());
                    break;
                case "patronymic":
                    enrollee.setPatronymic(keyValue.getValue());
                    break;
                case "specialityById":
                    enrollee.setSpeciality(getEnrolleeDao().getSpecialityById(keyValue.getValue()));
                    break;
            }
        }


    }

    @Override
    public void undo() {
        enrollee.setFname(enrolleeBefore.getFname());
        enrollee.setLname(enrolleeBefore.getLname());
        enrollee.setPatronymic(enrolleeBefore.getPatronymic());
        enrollee.setSpeciality(enrolleeBefore.getSpeciality());
    }

    @Override
    public String getMessage() {
        return (enrolleeBefore != null) ? "Изменить абитериента " + enrolleeBefore.getId() : null;
    }
}
