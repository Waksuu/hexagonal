package pl.kacper.starzynski.hexagon.api;

import pl.kacper.starzynski.hexagon.domain.Account;

public interface AccountRepository {
    Account findById(AccountId accountId);

    void save(Account account);
}
