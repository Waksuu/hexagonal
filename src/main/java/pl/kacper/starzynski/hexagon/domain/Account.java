package pl.kacper.starzynski.hexagon.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {
    private final AccountId id;
    private Balance balance;

    public void addBalance(Balance newBalance) {
        balance = balance.add(newBalance);
    }

    public void withdraw(Balance withdrawAmount) {
        balance = balance.withdraw(withdrawAmount);
    }
}
