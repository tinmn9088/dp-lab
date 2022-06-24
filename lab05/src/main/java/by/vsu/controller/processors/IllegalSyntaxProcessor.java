package by.vsu.controller.processors;

public class IllegalSyntaxProcessor implements Processor {

    @Override
    public void process(String userInput) {
        System.out.printf("Ошибка: неизвестная команда \"%s\"\n", userInput);
    }

    @Override
    public void setNext(Processor next) {
    }
}
