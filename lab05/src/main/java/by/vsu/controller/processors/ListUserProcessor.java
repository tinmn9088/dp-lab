package by.vsu.controller.processors;

import by.vsu.controller.commands.ListUserCommand;
import by.vsu.service.EnrolleeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListUserProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().equals("list-user")) {
            enrolleeService.execute(new ListUserCommand());
        } else {
            next.process(userInput);
        }
    }
}
