package kots.customer.controller.response;

import kots.customer.domain.dto.AccountDto;
import kots.customer.domain.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerProductsResponse {

    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;
    private List<CardDto> cards;
}
