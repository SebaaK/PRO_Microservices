package kots.customer.connector;

import kots.customer.domain.dto.GetCardsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsConnector {

    @GetMapping("/cards")
    GetCardsResponse getCards(@RequestParam("customerId") Long customerId);
}
