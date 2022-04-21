package kots.cards.mapper;

import kots.cards.domain.Cards;
import kots.cards.domain.dto.CardsDto;

import java.util.List;
import java.util.stream.Collectors;

public class CardsMapper {

    public static Cards mapToCards(final CardsDto cardsDto) {
        return new Cards(
                cardsDto.getId(),
                cardsDto.getNumberCard(),
                cardsDto.getType(),
                cardsDto.getCustomerId()
        );
    }

    public static CardsDto mapToCardsDto(final Cards cards) {
        return new CardsDto(
                null,
                cards.getNumberCard(),
                cards.getCardType(),
                null
        );
    }

    public static List<CardsDto> mapToCardsDto(final List<Cards> cardsList) {
        return cardsList.stream()
                .map(CardsMapper::mapToCardsDto)
                .collect(Collectors.toList());
    }
}
