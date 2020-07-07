package pl.kacper.starzynski.hexagon.domain;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@RequiredArgsConstructor(staticName = "create")
public class Balance {
    private final BigDecimal value;
    private final Currency currency;

    Balance add(Balance newBalance) {
        if (currencyDoesNotMatch(newBalance)) {
            throw new RuntimeException("Currency does not match");
        }

        if (isNegative(newBalance)) {
            throw new RuntimeException("New balance value is negative");
        }

        return new Balance(value.add(newBalance.value), currency);
    }

    private boolean isNegative(Balance newBalance) {
        return newBalance.value.compareTo(BigDecimal.ZERO) < 0;
    }

    public Balance withdraw(Balance withdrawAmount) {
        if (currencyDoesNotMatch(withdrawAmount)) {
            throw new RuntimeException("Currency does not match");
        }

        if (isPositive(withdrawAmount)) {
            throw new RuntimeException("New balance value is negative");
        }

        if (isOverdraft(withdrawAmount)) {
            throw new RuntimeException("Withdraw amount exceeded balance");
        }

        return new Balance(value.add(withdrawAmount.value), currency);
    }

    private boolean currencyDoesNotMatch(Balance newBalance) {
        return !currency.equals(newBalance.currency);
    }

    private boolean isOverdraft(Balance withdrawAmount) {
        return withdrawAmount.value.compareTo(value) > 0;
    }

    private boolean isPositive(Balance withdrawAmount) {
        return withdrawAmount.value.compareTo(BigDecimal.ZERO) > 0;
    }
}
