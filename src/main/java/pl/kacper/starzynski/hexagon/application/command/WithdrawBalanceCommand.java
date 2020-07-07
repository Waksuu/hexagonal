package pl.kacper.starzynski.hexagon.application.command;

import lombok.Value;

import java.util.UUID;

@Value
public class WithdrawBalanceCommand {
    UUID accountId;
    String withdrawAmount;
    String currency;
}
