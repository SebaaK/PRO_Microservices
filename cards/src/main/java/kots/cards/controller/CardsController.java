package kots.cards.controller;

import kots.cards.domain.GetCardsResponse;
import kots.cards.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static kots.cards.mapper.CardsMapper.mapToCardsDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
class CardsController {

    private final CardsService cardsService;

    @GetMapping
    public GetCardsResponse getCardsByCustomerId(@RequestParam Long customerId) {
        return GetCardsResponse.of(mapToCardsDto(cardsService.getCardsByCustomerId(customerId)));
    }
}
