package by.vsu.controller;

import by.vsu.controller.processors.Processor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class EnrolleeController {

    @NonNull
    private Processor firstProcessor;

    public void process(String userInput) {
        firstProcessor.process(userInput);
    }
}
