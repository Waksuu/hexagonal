package pl.kacper.starzynski.hexagon.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kacper.starzynski.hexagon.api.AccountRepository;
import pl.kacper.starzynski.hexagon.api.AccountService;
import pl.kacper.starzynski.hexagon.api.command.AddBalanceCommand;
import pl.kacper.starzynski.hexagon.api.command.WithdrawBalanceCommand;
import pl.kacper.starzynski.hexagon.domain.Account;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public void addBalance(AddBalanceCommand command) {
        Account account = accountRepository.findById(command.getAccountId());
        account.addBalance(command.getNewBalance());
        accountRepository.save(account);
    }

    public void withdraw(WithdrawBalanceCommand command) {
        Account account = accountRepository.findById(command.getAccountId());
        account.withdraw(command.getWithdrawAmount());
        accountRepository.save(account);
    }
}
