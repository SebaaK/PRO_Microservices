package kots.customer.service;

import kots.customer.domain.dto.AccountDto;
import kots.customer.domain.dto.CardDto;
import kots.customer.provider.AccountsProvider;
import kots.customer.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountsProvider;
    private final CardsProvider cardsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountsProvider.getCustomerAccounts(customerId);
    }

    public List<CardDto> findCardsOfCustomer(Long customerId) {
        return cardsProvider.getCardsAccounts(customerId);
    }
}
