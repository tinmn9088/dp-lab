package by.vsu;

import by.vsu.flat.Flat;
import by.vsu.flat.FlatsFactory;
import by.vsu.request.Request;
import by.vsu.request.RequestsFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class Main {

    public static void main(String[] args) {
        List<Flat> flats = getFlats();
        List<Request> requests = getRequests();
        List<FlatDecorator> flatHours = new ArrayList<>();

        for (Flat flat : flats) {
            int hours = 0;
            for (Request request : requests) {
                if (request.getFlatNumber().equals(flat.getNumber())) {
                    hours += request.getHours();
                }
            }
            flatHours.add(new FlatDecorator(flat, hours));
        }
        flatHours.sort((f1, f2) -> -Integer.compare(f1.getHours(), f2.getHours()));
        for (FlatDecorator fd : flatHours) {
            System.out.printf(" * Квартира %s - %d ч.\n", fd.getNumber(), fd.getHours());
        }
    }

    private static class FlatDecorator extends Flat {

        private Flat flat;

        private int hours;

        public FlatDecorator(Flat flat, int hours) {
            this.flat = requireNonNull(flat);
            this.hours = hours;
        }

        @Override
        public String getNumber() {
            return flat.getNumber();
        }

        @Override
        public String getEntrance() {
            return flat.getEntrance();
        }

        @Override
        public String getFloor() {
            return flat.getFloor();
        }

        @Override
        public String getOwner() {
            return flat.getOwner();
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }
    }

    private static List<Flat> getFlats() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Квартиры:");
        String ext = getExt(userInput);
        String name = getName(userInput);
        System.out.printf("Вы ввели \"%s\" и \"%s\"\n\n", ext, name);
        return FlatsFactory.INSTANCE.create(ext, name);
    }

    private static List<Request> getRequests() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Заявки:");
        String ext = getExt(userInput);
        String name = getName(userInput);
        System.out.printf("Вы ввели \"%s\" и \"%s\"\n\n", ext, name);
        return RequestsFactory.INSTANCE.create(ext, name);
    }

    private static String getExt(Scanner userInput) {
        return getUserInput("  Расширение файла", userInput);
    }

    private static String getName(Scanner userInput) {
        return getUserInput("  Имя файла", userInput);
    }

    private static String getUserInput(String description, Scanner userInput) {
        System.out.printf("%s >>> ", description);
        return userInput.nextLine().strip();
    }
}
