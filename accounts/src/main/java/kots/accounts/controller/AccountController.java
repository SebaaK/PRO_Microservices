package kots.accounts.controller;

import kots.accounts.domain.Account;
import kots.accounts.domain.GetAccountsResponse;
import kots.accounts.mapper.AccountMapper;
import kots.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/accounts")
class AccountController {

    private final AccountService service;

    @GetMapping
    ResponseEntity<GetAccountsResponse> getAccountsById(@RequestParam Long customerId) {
        List<Account> accountList = service.searchAccountByCustomerId(customerId);
//        return new ResponseEntity<>(
//                GetAccountsResponse.of(AccountMapper.mapToAccountDtoWithoutCustomerId(accountList)),
//                HttpStatus.OK
//        );
        return ResponseEntity.ok(GetAccountsResponse.of(AccountMapper.mapToAccountDtoWithoutCustomerId(accountList)));
    }
}
