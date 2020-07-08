package pl.kacper.starzynski.hexagon.domain;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@RequiredArgsConstructor(staticName = "create")
public class Money {
    // This probably should be VO on its own
    // Validations etc/changed logic
    private final long wholeNumber;
    private final long decimalNumber;
    private final Currency currency;

    Money add(Money addAmount) {
        if (currencyDoesNotMatch(addAmount)) {
            throw new RuntimeException("Currency does not match");
        }

        if (addAmount.isNegative()) {
            throw new RuntimeException("Cannot add negative amount");
        }

        return new Money(value.add(addAmount.value), currency);
    }

    private boolean isNegative() {
        return value.compareTo(BigDecimal.ZERO) < 0;
    }

    Money subtract(Money money) {
        if (currencyDoesNotMatch(money)) {
            throw new RuntimeException("Currency does not match");
        }

        if (money.isPositive()) {
            throw new RuntimeException("Cannot subtract positive amount");
        }

        return new Money(value.add(money.value), currency);
    }

    private boolean isPositive() {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }

    boolean isGreaterThan(Money money) {
        if (currencyDoesNotMatch(money)) {
            throw new RuntimeException("Currency does not match");
        }

        return value.compareTo(money.value) > 0;
    }

    private boolean currencyDoesNotMatch(Money money) {
        return !currency.equals(money.currency);
    }
}
