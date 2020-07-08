package pl.kacper.starzynski.hexagon.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kacper.starzynski.hexagon.application.command.AddBalanceCommand;
import pl.kacper.starzynski.hexagon.application.command.WithdrawBalanceCommand;
import pl.kacper.starzynski.hexagon.domain.Account;
import pl.kacper.starzynski.hexagon.domain.AccountId;
import pl.kacper.starzynski.hexagon.domain.AccountRepository;
import pl.kacper.starzynski.hexagon.domain.Money;

import java.math.BigDecimal;
import java.util.Currency;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void addBalance(AddBalanceCommand command) {
        Account account = accountRepository.findById(AccountId.of(command.getAccountId()));
        account.addBalance(Money.create(new BigDecimal(command.getNewBalance()), Currency.getInstance(command.getCurrency())));
        accountRepository.save(account);
    }

    public void withdraw(WithdrawBalanceCommand command) {
        Account account = accountRepository.findById(AccountId.of(command.getAccountId()));
        account.withdraw(Money.create(new BigDecimal(command.getWithdrawAmount()), Currency.getInstance(command.getCurrency())));
        accountRepository.save(account);
    }
}
