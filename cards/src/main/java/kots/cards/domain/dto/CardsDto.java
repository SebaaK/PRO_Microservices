package kots.cards.domain.dto;

import kots.cards.domain.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardsDto {

    private Long id;
    private String numberCard;
    private CardType type;
    private Long customerId;
}
