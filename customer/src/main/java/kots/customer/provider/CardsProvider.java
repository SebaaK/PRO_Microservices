package kots.customer.provider;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kots.customer.connector.CardsConnector;
import kots.customer.domain.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {

    private final CardsConnector cardsConnector;

    @HystrixCommand(fallbackMethod = "fallbackCardsAccounts")
    public List<CardDto> getCardsAccounts(Long customerId) {
        return cardsConnector.getCards(customerId).getCards().stream()
                .map(card -> new CardDto(
                        card.getNumberCard(),
                        card.getType()
                ))
                .collect(Collectors.toList());
    }

    private List<CardDto> fallbackCardsAccounts(Long customerId) {
        return Collections.emptyList();
    }
}
