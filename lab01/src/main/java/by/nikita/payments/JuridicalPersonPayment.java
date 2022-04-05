package by.nikita.payments;

import java.math.BigDecimal;
import java.util.Map;

public abstract class JuridicalPersonPayment extends Payment {

    private static final long serialVersionUID = 1L;

    private final String juridicalPersonName;

    private final String governmentRegistrationNumber;

    private final String ownerSurname;

    private final String ownerName;

    private final String ownerPatronymic;

    public JuridicalPersonPayment(
            String recipient,
            BigDecimal amount,
            String juridicalPersonName,
            String governmentRegistrationNumber,
            String ownerSurname,
            String ownerName,
            String ownerPatronymic) {
        super(recipient, amount);
        this.juridicalPersonName = juridicalPersonName;
        this.governmentRegistrationNumber = governmentRegistrationNumber;
        this.ownerSurname = ownerSurname;
        this.ownerName = ownerName;
        this.ownerPatronymic = ownerPatronymic;
    }

    public String getGovernmentRegistrationNumber() {
        return governmentRegistrationNumber;
    }

    public String getJuridicalPersonName() {
        return juridicalPersonName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerPatronymic() {
        return ownerPatronymic;
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();

        data.put("juridicalPersonName", getJuridicalPersonName());
        data.put("governmentRegistrationNumber", getGovernmentRegistrationNumber());
        data.put("ownerSurname", getOwnerSurname());
        data.put("ownerName", getOwnerName());
        data.put("ownerPatronymic", getOwnerPatronymic());

        return data;
    }
}
