package by.vsu.service;

import by.vsu.controller.commands.Command;
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
        history.add(command);
    }

    @Override
    public void undo() {
        Command lastCommand = history.pop();
        lastCommand.undo();
    }
}
