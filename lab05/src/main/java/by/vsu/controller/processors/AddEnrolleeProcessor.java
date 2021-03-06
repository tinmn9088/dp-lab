package by.vsu.controller.processors;

import by.vsu.service.EnrolleeService;
import by.vsu.service.commands.AddEnrolleeCommand;
import by.vsu.service.commands.Command;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class AddEnrolleeProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().matches("add-enrollee\\s+[\\w-]+\\s+[\\w-]+\\s+[\\w-]+\\s+[\\w-]+")) {
            String[] values = userInput.split("\\s+");
            String fname = values[1];
            String lname = values[2];
            String patronymic = values[3];
            String specialityId = values[4];
            System.out.printf("Имя: %s\nФамилия: %s\nОтчество: %s\nСпециальность: %s\n",
                    fname, lname, patronymic, specialityId);
            try {
                Command command = new AddEnrolleeCommand(fname, lname, patronymic, specialityId);
                enrolleeService.execute(command);
                System.out.println("Выполнено: " + command.getMessage());
            } catch (Exception ex) {
                System.out.println("Ошибка: " + ex.getMessage());
            }
        } else {
            next.process(userInput);
        }
    }
}
