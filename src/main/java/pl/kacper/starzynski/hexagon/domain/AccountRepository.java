package pl.kacper.starzynski.hexagon.domain;

public interface AccountRepository {
    Account findById(AccountId accountId);

    void save(Account account);
}
