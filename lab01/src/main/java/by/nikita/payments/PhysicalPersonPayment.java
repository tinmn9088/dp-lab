package by.nikita.payments;

import java.math.BigDecimal;
import java.util.Map;

public abstract class PhysicalPersonPayment extends Payment {

    private static final long serialVersionUID = 1L;

    private final String surname;

    private final String name;

    private final String patronymic;

    private final String passportSeries;

    private final String passportNumber;

    public PhysicalPersonPayment(
            String recipient,
            BigDecimal amount,
            String surname,
            String name,
            String patronymic,
            String passportSeries,
            String passportNumber) {
        super(recipient, amount);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();

        data.put("surname", getSurname());
        data.put("name", getName());
        data.put("patronymic", getPatronymic());
        data.put("passportSeries", getPassportSeries());
        data.put("passportNumber", getPassportNumber());

        return data;
    }
}
