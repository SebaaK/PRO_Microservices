package kots.accounts.domain;

import kots.accounts.domain.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class GetAccountsResponse {

    private List<AccountDto> accounts;
}
