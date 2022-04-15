package kots.accounts.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
    private Long customerId;
}
