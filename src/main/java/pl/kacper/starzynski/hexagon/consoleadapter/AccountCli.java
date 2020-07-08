package pl.kacper.starzynski.hexagon.consoleadapter;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kacper.starzynski.hexagon.api.AccountId;
import pl.kacper.starzynski.hexagon.api.AccountService;
import pl.kacper.starzynski.hexagon.api.Money;
import pl.kacper.starzynski.hexagon.api.command.AddBalanceCommand;

import java.util.Currency;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class AccountCli implements CommandLineRunner {
    private final AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(AccountCli.class, args);
    }

    @Override
    public void run(String... args) {
        UUID accountId = null; //read from console
        String newBalance = null; //read from console
        String currency = null; //read from console

        accountService.addBalance(new AddBalanceCommand(AccountId.of(accountId),
                Money.create(getWholeNumber(newBalance), getDecimalNumber(newBalance), Currency.getInstance(currency))));
    }

    private long getWholeNumber(String newBalance) {
        return Long.parseLong(getSplittedDecimalValue(newBalance)[0]);
    }

    private long getDecimalNumber(String newBalance) {
        return Long.parseLong(getSplittedDecimalValue(newBalance)[1]);
    }

    private String[] getSplittedDecimalValue(String newBalance) {
        return newBalance.split("\\.");
    }
}
