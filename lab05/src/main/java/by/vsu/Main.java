package by.vsu;

import by.vsu.controller.EnrolleeController;
import by.vsu.controller.processors.*;
import by.vsu.dao.EnrolleeDao;
import by.vsu.dao.EnrolleeDaoImpl;
import by.vsu.service.EnrolleeService;
import by.vsu.service.EnrolleeServiceImpl;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Абитуриенты:");

        // processors
        EnrolleeDao enrolleeDao = loadEnrolleeDao();
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
        editEnrolleeProcessor.setNext(new IllegalSyntaxProcessor());

        EnrolleeController enrolleeController = new EnrolleeController(undoProcessor);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> ");
        String userInput = scanner.nextLine();
        do {
            if (userInput.equals("save")) {
                saveEnrolleeDao(enrolleeDao);
            } else {
                enrolleeController.process(userInput);
            }
            System.out.print(">>> ");
            userInput = scanner.nextLine();
        } while (!userInput.equals("exit"));
    }

    private static EnrolleeDao loadEnrolleeDao() throws IOException, ClassNotFoundException {
        File file = new File(Main.class.getClassLoader().getResource(".").getFile() + "/data.bin");
        EnrolleeDao enrolleeDao = (EnrolleeDao) new ObjectInputStream(new FileInputStream(file)).readObject();
        System.out.println("Загружено из " + file);
        return enrolleeDao;
    }

    private static void saveEnrolleeDao(EnrolleeDao enrolleeDao) throws IOException, ClassNotFoundException {
        File existingFile = new File(Main.class.getClassLoader().getResource(".").getFile() + "/data.bin");
        if (existingFile.exists()) {
            existingFile.delete();
        }

        File file = new File(Main.class.getClassLoader().getResource(".").getFile() + "/data.bin");
        new ObjectOutputStream(new FileOutputStream(file)).writeObject(enrolleeDao);
        System.out.println("Сохарнено в " + file);
    }
}
