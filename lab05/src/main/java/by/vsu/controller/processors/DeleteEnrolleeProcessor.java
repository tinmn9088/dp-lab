package by.vsu.controller.processors;

import by.vsu.service.EnrolleeService;
import by.vsu.service.commands.AddEnrolleeCommand;
import by.vsu.service.commands.Command;
import by.vsu.service.commands.DeleteEnrolleeCommand;
import by.vsu.service.commands.ListEnrolleeCommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class DeleteEnrolleeProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().matches("delete-enrollee\\s+[\\w-]+")) {
            String[] values = userInput.split("\\s+");
            String enrolleeId = values[1];
            try {
                Command command = new DeleteEnrolleeCommand(enrolleeId);
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
