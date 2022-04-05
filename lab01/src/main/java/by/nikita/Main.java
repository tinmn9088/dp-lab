package by.nikita;

import by.nikita.data.DataTablePrinter;
import by.nikita.payments.Payment;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {
            Payment[] payments;
            final Class<? extends Payment> paymentType;
            final String columnName;

            // load payments from file
            payments = new PaymentsLoader().load();
            System.out.printf("[ OK ] Payments loaded (%d).\n", payments.length);

            // ask user which payment type to print
            System.out.println();
            paymentType = choosePaymentType(userInput, payments);
            System.out.printf("Your choice: %s\n", paymentType.getSimpleName());

            // ask user by what column to sort
            System.out.println();
            columnName = chooseColumn(userInput, findPaymentOfNeededType(payments, paymentType));
            System.out.printf("Your choice: %s\n", columnName);

            // filter and sort
            payments = Arrays.stream(payments)
                    .filter(paymentType::isInstance)
                    .sorted(Comparator.comparing(p -> p.getData().get(columnName)))
                    .toArray(Payment[]::new);

            // print
            new DataTablePrinter(payments).print();
        } catch (Exception e) {
            System.out.printf("[STOP] %s\n",
                    e.getMessage() != null ? e.getMessage() : e.getClass().getSimpleName());
        }
    }

    /**
     * Ask user which payments type to show.
     */
    private static Class<? extends Payment> choosePaymentType(
            Scanner userInput, Payment[] payments) {

        // get set of all types available
        Map<Integer, Class<? extends Payment>> types = new TreeMap<>();
        int numberOfTypes = 0;
        int answer = 0;

        for (Payment p : payments) {
            if (!types.containsValue(p.getClass())) {
                types.put(++numberOfTypes, p.getClass());
            }
        }

        System.out.println("Which type to show?");
        for (Map.Entry<Integer, Class<? extends Payment>> e : types.entrySet()) {
            System.out.printf("  %d. %s\n", e.getKey(), e.getValue().getSimpleName());
        }

        do {
            System.out.printf("Input number (1-%d): ", numberOfTypes);
            answer = userInput.nextInt();
        } while (answer < 1 || answer > numberOfTypes);

        return types.get(answer);
    }

    /**
     * @throws IllegalArgumentException if no instances found in array
     */
    private static Payment findPaymentOfNeededType(
            Payment[] payments, Class<? extends Payment> paymentType)
            throws IllegalArgumentException {
        Payment payment = null;

        for (Payment p : payments) {
            if (paymentType.isInstance(p)) {
                payment = p;
                break;
            }
        }

        if (payment == null) {
            throw new IllegalArgumentException(String
                    .format("No %s found", paymentType.getSimpleName()));
        }

        return payment;
    }

    /**
     * @param payment any instance
     */
    private static String chooseColumn(Scanner userInput, Payment payment) {

        int answer = 0;

        // get set of all column names available
        String[] columnNames = payment.getData().keySet().toArray(new String[0]);

        System.out.println("By which column to sort?");
        for (int i = 1; i <= columnNames.length; i++) {
            System.out.printf("  %d. %s\n", i, columnNames[i - 1]);
        }

        do {
            System.out.printf("Input number (1-%d): ", columnNames.length);
            answer = userInput.nextInt();
        } while (answer < 1 || answer > columnNames.length);

        return columnNames[answer - 1];
    }
}
