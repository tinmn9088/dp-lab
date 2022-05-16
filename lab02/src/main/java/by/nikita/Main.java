package by.nikita;

import by.nikita.data.cards.CardsFactory;
import by.nikita.data.cards.table.CarltonSolitaireCardTableImpl;
import by.nikita.data.cards.table.controllers.CarltonSolitaireController;
import by.nikita.data.cards.table.controllers.CarltonSolitaireControllerImpl;

import java.util.Scanner;

public class Main {

    private static final String QUIT_STR = "exit";

    public static void main(String[] args) {
        System.out.println("+-----------------------------------+");
        System.out.println("|         Carlton Solitaire         |");
        System.out.println("+-----------------------------------+");

        CarltonSolitaireCardTableImpl cardTable =
                new CarltonSolitaireCardTableImpl(new CardsFactory().createDeckOfCards());
        Scanner scanner = new Scanner(System.in);
        CarltonSolitaireController controller = new CarltonSolitaireControllerImpl(cardTable);

        cardTable.print();
        System.out.print(">>> "); String userInput = scanner.nextLine();
        while (!userInput.equals(QUIT_STR) || cardTable.gameContinues()) {
            controller.process(userInput);
            cardTable.print();
            System.out.print(">>> "); userInput = scanner.nextLine();
        }

        System.out.println("Game finished");
    }
}
