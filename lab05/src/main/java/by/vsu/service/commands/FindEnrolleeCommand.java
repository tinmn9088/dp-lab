package by.vsu.service.commands;

import by.vsu.models.Enrollee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FindEnrolleeCommand extends Command {

    @NonNull
    Map<String, String> flags;

    @Override
    public void run() {
        Set<Enrollee> enrollees = getEnrolleeDao().getAllEnrollees();

        outer: for (Map.Entry<String, String> keyValue : flags.entrySet()) {
            switch (keyValue.getKey()) {
                case "--id":
                    enrollees = enrollees.stream()
                            .filter(e -> e.getId().equals(keyValue.getValue()))
                            .collect(Collectors.toSet());
                    break;
                case "--fname":
                    enrollees = enrollees.stream()
                            .filter(e -> e.getFname().equals(keyValue.getValue()))
                            .collect(Collectors.toSet());
                    break;
                default:
                    enrollees.clear();
                    break outer;
            }
        }

        System.out.println(" Найдено:");
        int number = 1;
        for (Enrollee e : enrollees) {
            System.out.printf("  %d. %s\n", number++, e);
        }
    }

    @Override
    public void undo() {
    }
}
