package pl.kacper.starzynski.hexagon.api;

import pl.kacper.starzynski.hexagon.api.command.AddBalanceCommand;
import pl.kacper.starzynski.hexagon.api.command.WithdrawBalanceCommand;

public interface AccountService {
    void addBalance(AddBalanceCommand addBalanceCommand);

    void withdraw(WithdrawBalanceCommand withdrawBalanceCommand);
}
