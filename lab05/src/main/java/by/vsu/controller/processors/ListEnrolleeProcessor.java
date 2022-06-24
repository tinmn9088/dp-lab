package by.vsu.controller.processors;

import by.vsu.service.commands.ListEnrolleeCommand;
import by.vsu.service.EnrolleeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListEnrolleeProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().equals("list-enrollee")) {
            enrolleeService.execute(new ListEnrolleeCommand());
        } else {
            next.process(userInput);
        }
    }
}
