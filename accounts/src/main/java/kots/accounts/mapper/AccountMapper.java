package kots.accounts.mapper;

import kots.accounts.domain.Account;
import kots.accounts.domain.dto.AccountDto;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {

    public static AccountDto mapToAccountDtoWithoutCustomerId(final Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .nrb(account.getNrb())
                .currency(account.getCurrency())
                .availableFunds(account.getAvailableFunds())
                .build();
    }
    
    public static List<AccountDto> mapToAccountDtoWithoutCustomerId(final List<Account> accountList) {
        return accountList.stream()
                .map(AccountMapper::mapToAccountDtoWithoutCustomerId)
                .collect(Collectors.toList());
    }

}
