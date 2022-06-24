package by.vsu.service;

import by.vsu.controller.commands.Command;

public interface EnrolleeService {

    void execute(Command command);

    void undo();
}
