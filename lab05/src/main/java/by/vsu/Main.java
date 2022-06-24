package by.vsu;

import by.vsu.controller.EnrolleeController;
import by.vsu.controller.processors.*;
import by.vsu.dao.EnrolleeDao;
import by.vsu.dao.EnrolleeDaoImpl;
import by.vsu.service.EnrolleeService;
import by.vsu.service.EnrolleeServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Абитуриенты:");

        // processors
        EnrolleeDao enrolleeDao = new EnrolleeDaoImpl();
        EnrolleeService enrolleeService = new EnrolleeServiceImpl(enrolleeDao);
        UndoProcessor undoProcessor = new UndoProcessor(enrolleeService);
        ListEnrolleeProcessor listEnrolleeProcessor = new ListEnrolleeProcessor(enrolleeService);
        AddEnrolleeProcessor addEnrolleeProcessor = new AddEnrolleeProcessor(enrolleeService);
        DeleteEnrolleeProcessor deleteEnrolleeProcessor = new DeleteEnrolleeProcessor(enrolleeService);
        FindEnrolleeProcessor findEnrolleeProcessor = new FindEnrolleeProcessor(enrolleeService);
        EditEnrolleeProcessor editEnrolleeProcessor = new EditEnrolleeProcessor(enrolleeService);
        undoProcessor.setNext(listEnrolleeProcessor);
        listEnrolleeProcessor.setNext(addEnrolleeProcessor);
        addEnrolleeProcessor.setNext(deleteEnrolleeProcessor);
        deleteEnrolleeProcessor.setNext(findEnrolleeProcessor);
        findEnrolleeProcessor.setNext(editEnrolleeProcessor);

        EnrolleeController enrolleeController = new EnrolleeController(undoProcessor);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> ");
        String userInput = scanner.nextLine();
        do {
            enrolleeController.process(userInput);
            System.out.print(">>> ");
            userInput = scanner.nextLine();
        } while (!userInput.equals("exit"));
    }
}
