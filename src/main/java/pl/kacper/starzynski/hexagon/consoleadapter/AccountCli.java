package pl.kacper.starzynski.hexagon.consoleadapter;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kacper.starzynski.hexagon.HexagonApplication;
import pl.kacper.starzynski.hexagon.application.AccountService;
import pl.kacper.starzynski.hexagon.application.command.AddBalanceCommand;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class AccountCli implements CommandLineRunner {
    private final AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(HexagonApplication.class, args);
    }

    @Override
    public void run(String... args) {
        UUID accountId = null; //read from console
        String newBalance = null; //read from console
        String currency = null; //read from console

        accountService.addBalance(new AddBalanceCommand(accountId, newBalance, currency));
    }
}
