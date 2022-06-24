package by.vsu.service.commands;

import by.vsu.models.Enrollee;

public class ListEnrolleeCommand extends Command {

    @Override
    public void run() {
        int number = 1;
        for (Enrollee e : getEnrolleeDao().getAllEnrollees()) {
            System.out.printf(" %d. %s\n", number++, e);
        }
    }

    @Override
    public void undo() {
    }
}
