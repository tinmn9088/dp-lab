package by.vsu.controller.commands;

import by.vsu.dao.EnrolleeDao;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public abstract class Command implements Runnable {

    @Setter @NonNull @Getter
    private EnrolleeDao enrolleeDao;

    public abstract void undo();
}
