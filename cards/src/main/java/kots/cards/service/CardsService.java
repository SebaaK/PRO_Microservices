package kots.cards.service;

import kots.cards.domain.Cards;
import kots.cards.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {

    private final CardsRepository repository;

    public List<Cards> getCardsByCustomerId(Long customerId) {
        return repository.findCardsByCustomerId(customerId);
    }
}
