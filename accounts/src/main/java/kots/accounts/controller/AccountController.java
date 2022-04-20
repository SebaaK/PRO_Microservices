package kots.accounts.controller;

import kots.accounts.domain.Account;
import kots.accounts.domain.GetAccountsResponse;
import kots.accounts.mapper.AccountMapper;
import kots.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/accounts")
@RefreshScope
class AccountController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final AccountService service;

    @GetMapping
    ResponseEntity<GetAccountsResponse> getAccountsById(@RequestParam Long customerId) {
        log.info("Get accounts for idCustomer: {}", customerId);
        if(!allowGetAccounts)
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "This endpoint is temporary off. Try again later.");
        List<Account> accountList = service.searchAccountByCustomerId(customerId);
        return ResponseEntity.ok(GetAccountsResponse.of(AccountMapper.mapToAccountDtoWithoutCustomerId(accountList)));
    }
}
