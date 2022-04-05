package by.nikita;

import by.nikita.payments.Payment;

import java.io.*;
import java.net.URL;

public class PaymentsLoader {

    public static final String PAYMENTS_RESOURCE_NAME = "payments.bin";

    /**
     * @return deserialized payments
     * @throws IOException if resource file not found, or data is invalid
     */
    public Payment[] load() throws IOException {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(getResourceFile()))) {
            return (Payment[]) ois.readObject();
        } catch (ClassNotFoundException | EOFException e) {
            throw new IOException(String
                    .format("\"%s\" doesn't store payments", PAYMENTS_RESOURCE_NAME));
        }
    }

    /**
     * @return valid File instance
     * @throws IOException if file not found
     */
    private File getResourceFile() throws IOException {
        URL resourceURL = getClass().getClassLoader().getResource(PAYMENTS_RESOURCE_NAME);

        if (resourceURL == null) {
            throw new IOException(String
                    .format("\"%s\" not found", PAYMENTS_RESOURCE_NAME));
        }

        return new File(resourceURL.getFile());
    }
}
