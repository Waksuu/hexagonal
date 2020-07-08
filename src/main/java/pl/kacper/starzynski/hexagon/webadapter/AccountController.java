package pl.kacper.starzynski.hexagon.webadapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kacper.starzynski.hexagon.api.AccountId;
import pl.kacper.starzynski.hexagon.api.AccountService;
import pl.kacper.starzynski.hexagon.api.Money;
import pl.kacper.starzynski.hexagon.api.command.AddBalanceCommand;
import pl.kacper.starzynski.hexagon.api.command.WithdrawBalanceCommand;
import pl.kacper.starzynski.hexagon.webadapter.request.AddBalanceRequest;
import pl.kacper.starzynski.hexagon.webadapter.request.WithdrawBalanceRequest;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PutMapping("/{accountId}/add-balance")
    public void addBalance(@PathVariable UUID accountId, @RequestBody AddBalanceRequest request) {
        accountService.addBalance(new AddBalanceCommand(AccountId.of(accountId),
                Money.create(new BigDecimal(request.getNewBalance()), Currency.getInstance(request.getCurrency()))));
    }

    @PutMapping("/{accountId}/withdraw-balance")
    public void withdrawBalance(@PathVariable UUID accountId, @RequestBody WithdrawBalanceRequest request) {
        accountService.withdraw(new WithdrawBalanceCommand(AccountId.of(accountId),
                Money.create(new BigDecimal(request.getWithdrawAmount()), Currency.getInstance(request.getCurrency()))));
    }
}
