package kots.accounts.service;

import kots.accounts.domain.Account;
import kots.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public List<Account> searchAccountByCustomerId(Long customerId) {
        return repository.findAccountsByCustomerId(customerId);
    }
}
