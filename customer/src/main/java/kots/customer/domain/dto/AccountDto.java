package kots.customer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
}
