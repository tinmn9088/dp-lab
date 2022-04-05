package by.nikita.payments;

import by.nikita.data.DataHolder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Payment implements DataHolder {

    private static final long serialVersionUID = 1L;

    private final String recipient;

    private final BigDecimal amount;

    public Payment(String recipient, BigDecimal amount) {
        this.recipient = recipient;
        this.amount = amount;
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new HashMap<>(2);

        data.put("recipient", getRecipient());
        data.put("amount", getAmount().toPlainString());

        return data;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getRecipient() {
        return recipient;
    }
}
