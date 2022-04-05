package by.nikita.payments;

import java.math.BigDecimal;
import java.util.Map;

public class JuridicalPersonBillPayment extends JuridicalPersonPayment {

    private static final long serialVersionUID = 1L;

    private final String bankName;

    private final String accountNumber;

    public JuridicalPersonBillPayment(
            String recipient,
            BigDecimal amount,
            String juridicalPersonName,
            String governmentRegistrationNumber,
            String ownerSurname,
            String ownerName,
            String ownerPatronymic,
            String bankName,
            String accountNumber) {
        super(recipient, amount, juridicalPersonName, governmentRegistrationNumber,
                ownerSurname, ownerName, ownerPatronymic);
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
