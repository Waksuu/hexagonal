package pl.kacper.starzynski.hexagon.api.command;

import lombok.Value;
import pl.kacper.starzynski.hexagon.api.AccountId;
import pl.kacper.starzynski.hexagon.api.Money;

@Value
public class AddBalanceCommand {
    AccountId accountId;
    Money newBalance;
}