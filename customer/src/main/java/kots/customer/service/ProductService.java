package kots.customer.service;

import kots.customer.domain.dto.AccountDto;
import kots.customer.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountsProvider;

    public List<AccountDto> findCustomerAccounts(Long idCustomer) {
        return accountsProvider.getCustomerAccounts(idCustomer);
    }
}
