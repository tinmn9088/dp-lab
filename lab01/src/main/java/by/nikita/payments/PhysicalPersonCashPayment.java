package by.nikita.payments;

import java.math.BigDecimal;
import java.util.Map;

public class PhysicalPersonCashPayment extends PhysicalPersonPayment {

    private static final long serialVersionUID = 1L;

    private final String checkNumber;

    public PhysicalPersonCashPayment(
            String recipient,
            BigDecimal amount,
            String surname,
            String name,
            String patronymic,
            String passportSeries,
            String passportNumber,
            String checkNumber) {
        super(recipient, amount, surname, name, patronymic, passportSeries, passportNumber);
        this.checkNumber = checkNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();

        data.put("checkNumber", getCheckNumber());

        return data;
    }
}
