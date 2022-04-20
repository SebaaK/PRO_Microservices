package kots.customer.provider;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kots.customer.connector.AccountsConnector;
import kots.customer.domain.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

    @HystrixCommand(fallbackMethod = "fallbackCustomerAccounts")
    public List<AccountDto> getCustomerAccounts(Long idCustomer) {
        return accountsConnector.getAccounts(idCustomer).getAccounts().stream()
                .map(account -> new AccountDto(
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFunds()
                ))
                .collect(Collectors.toList());
    }

    private List<AccountDto> fallbackCustomerAccounts(Long idCustomer) {
        return Collections.emptyList();
    }

}
