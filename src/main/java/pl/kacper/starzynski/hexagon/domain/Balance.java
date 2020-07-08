package pl.kacper.starzynski.hexagon.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "create", access = AccessLevel.PACKAGE)
public class Balance {
    private final Money money;

    Balance add(Money addAmount) {
        return new Balance(money.add(addAmount));
    }

    public Balance withdraw(Money withdrawAmount) {
        if (isOverdraft(withdrawAmount)) {
            throw new RuntimeException("Withdraw amount exceeded balance");
        }

        return new Balance(money.subtract(withdrawAmount));
    }

    private boolean isOverdraft(Money withdrawAmount) {
        return withdrawAmount.isGreaterThan(money);
    }
}
