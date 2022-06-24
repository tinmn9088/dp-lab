package by.vsu.controller.processors;

import by.vsu.service.EnrolleeService;
import by.vsu.service.commands.FindEnrolleeCommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class FindEnrolleeProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().matches("find-enrollee(\\s+[\\w-]+)+")) {
            String[] values = userInput.split("\\s+");
            Map<String, String> flags = new HashMap<>();
            for (int i = 1; i < values.length; i += 2) {
                flags.put(values[i], values[i + 1]);
            }
            for (Map.Entry<String, String> e : flags.entrySet()) {
                System.out.printf(" flag: %s\tvalue: %s\n", e.getKey(), e.getValue());
            }
            enrolleeService.execute(new FindEnrolleeCommand(flags));
        } else {
            next.process(userInput);
        }
    }
}
