package by.vsu.controller.processors;

import by.vsu.service.EnrolleeService;
import by.vsu.service.commands.EditEnrolleeCommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class EditEnrolleeProcessor implements Processor {

    @NonNull
    private EnrolleeService enrolleeService;

    @Setter
    private Processor next;

    @Override
    public void process(String userInput) {
        if (userInput.strip().matches("edit-enrollee\\s+[\\w-]+\\s+set(\\s+[\\w-]+=[\\w-]+)+")) {
            String[] values = userInput.split("\\s+");
            String enrolleeId = values[1];
            Map<String, String> flags = new HashMap<>();
            for (int i = 3; i < values.length; i++) {
                String[] keyValue = values[i].split("=");
                flags.put(keyValue[0], keyValue[1]);
            }
            for (Map.Entry<String, String> e : flags.entrySet()) {
                System.out.printf(" flag: %s\tvalue: %s\n", e.getKey(), e.getValue());
            }
            enrolleeService.execute(new EditEnrolleeCommand(enrolleeId, flags));
        } else {
            next.process(userInput);
        }
    }
}
