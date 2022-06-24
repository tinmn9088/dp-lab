package by.vsu.controller.processors;


public interface Processor {

    void process(String userInput);

    void setNext(Processor next);
}
