package by.vsu.service;

import by.vsu.controller.processors.DataChange;
import by.vsu.service.commands.Command;
import by.vsu.dao.EnrolleeDao;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Stack;

@RequiredArgsConstructor
public class EnrolleeServiceImpl implements EnrolleeService {

    private Stack<Command> history = new Stack<>();

    @NonNull
    private EnrolleeDao enrolleeDao;

    @Override
    public void execute(Command command) {
        command.setEnrolleeDao(enrolleeDao);
        command.run();
        if (command instanceof DataChange) {
            history.add(command);
        }
    }

    @Override
    public Command undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
            return lastCommand;
        }
        return null;
    }
}
