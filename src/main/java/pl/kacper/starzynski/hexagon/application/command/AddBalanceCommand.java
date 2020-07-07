package pl.kacper.starzynski.hexagon.application.command;

import lombok.Value;

import java.util.UUID;

@Value
public class AddBalanceCommand {
    UUID accountId;
    String newBalance;
    String currency;
}
