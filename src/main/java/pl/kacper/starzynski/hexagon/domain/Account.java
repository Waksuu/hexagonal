package pl.kacper.starzynski.hexagon.domain;

import lombok.AllArgsConstructor;
import pl.kacper.starzynski.hexagon.api.AccountId;
import pl.kacper.starzynski.hexagon.api.Money;

@AllArgsConstructor
public class Account {
    private final AccountId id;
    private Balance balance;

    public void addBalance(Money newBalance) {
        balance = balance.add(newBalance);
    }

    public void withdraw(Money withdrawAmount) {
        balance = balance.withdraw(withdrawAmount);
    }
}
