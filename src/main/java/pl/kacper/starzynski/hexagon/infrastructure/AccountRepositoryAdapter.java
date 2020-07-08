package pl.kacper.starzynski.hexagon.infrastructure;

import org.springframework.stereotype.Repository;
import pl.kacper.starzynski.hexagon.domain.Account;
import pl.kacper.starzynski.hexagon.api.AccountId;
import pl.kacper.starzynski.hexagon.api.AccountRepository;

@Repository
class AccountRepositoryAdapter implements AccountRepository {
    @Override
    public Account findById(AccountId accountId) {
        return null;
    }

    @Override
    public void save(Account account) {

    }
}
