package by.vsu.service;

import by.vsu.service.commands.Command;

public interface EnrolleeService {

    void execute(Command command);

    Command undo();
}
