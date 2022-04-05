package by.nikita.payments;

import java.math.BigDecimal;
import java.util.Map;

public class PhysicalPersonBillPayment extends PhysicalPersonPayment {

    private static final long serialVersionUID = 1L;

    private final String bankName;

    private final String accountNumber;

    public PhysicalPersonBillPayment(
            String recipient,
            BigDecimal amount,
            String surname,
            String name,
            String patronymic,
            String passportSeries,
            String passportNumber,
            String bankName,
            String accountNumber) {
        super(recipient, amount, surname, name, patronymic, passportSeries, passportNumber);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();

        data.put("bankName", getBankName());
        data.put("accountNumber", getAccountNumber());

        return data;
    }
}
