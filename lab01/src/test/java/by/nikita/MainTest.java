package by.nikita;

import org.junit.Ignore;
import org.junit.Test;
import by.nikita.payments.JuridicalPersonBillPayment;
import by.nikita.payments.Payment;
import by.nikita.payments.PhysicalPersonBillPayment;
import by.nikita.payments.PhysicalPersonCashPayment;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class MainTest {

    @Ignore
    @Test
    public void writeTestData() throws Exception {
        Payment[] payments = {
                new PhysicalPersonBillPayment(
                        "E Corp",
                        new BigDecimal("12"),
                        "Alderson",
                        "Elliot",
                        "",
                        "UU",
                        "1234567",
                        "E Corp Bank",
                        "0987654321"),
                new PhysicalPersonCashPayment(
                        "E Corp",
                        new BigDecimal("10"),
                        "Alderson",
                        "Elliot",
                        "",
                        "UU",
                        "1234567",
                        "d213fg4dw3rt43"),
                new JuridicalPersonBillPayment(
                        "E Corp",
                        new BigDecimal("10.1"),
                        "E Corp",
                        "101",
                        "",
                        "",
                        "",
                        "E Corp Bank",
                        "125364574636"),
                new JuridicalPersonBillPayment(
                        "E Corp",
                        new BigDecimal("1.2"),
                        "E Corp",
                        "101",
                        "",
                        "",
                        "",
                        "E Corp Bank",
                        "125364574636"),
        };

        String outputFileAbsolutePath = "C:\\Users\\Mikita_Ivanou\\Desktop\\Lab01\\src\\main\\resources\\payments.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFileAbsolutePath))) {
            oos.writeObject(payments);
        }
    }
}
