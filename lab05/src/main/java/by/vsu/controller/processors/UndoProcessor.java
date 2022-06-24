package by.vsu.controller.processors;

import by.vsu.service.EnrolleeService;
import by.vsu.service.commands.Command;
import by.vsu.service.commands.ListEnrolleeCommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class UndoProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().equals("undo")) {
            Command command = enrolleeService.undo();
            if (command != null) {
                System.out.println("Отмена: " + command.getMessage());
            }
        } else {
            next.process(userInput);
        }
    }
}
