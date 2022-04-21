package kots.cards.domain;

import kots.cards.domain.dto.CardsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
public class GetCardsResponse {

    private List<CardsDto> cards;
}
