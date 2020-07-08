package pl.kacper.starzynski.hexagon.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void isGreaterThan() {
        Money money = Money.create(new BigDecimal("100"), Currency.getInstance("USD"));
        Money moreMoney = Money.create(new BigDecimal("120"), Currency.getInstance("USD"));

        assertTrue(moreMoney.isGreaterThan(money));
    }
}