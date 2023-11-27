package com.agregio.kata.infrastructure.offers;


import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.offers.Offer;
import com.agregio.kata.domain.usecases.OffersAPI;
import com.agregio.kata.domain.usecases.PwoFunctionalException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferApplication {
    private final OffersAPI offersAPI;

    public OfferApplication(OffersAPI offersAPI) {
        this.offersAPI = offersAPI;
    }

    public OfferDTO createOffer(OfferCreationDTO offerToCreate) throws PwoFunctionalException {
        Offer offer = offerToCreate.toDomain();
        return this.offersAPI.createOffer(offer)
                .map(OfferDTO::fromDomain)
                .orElseThrow();
    }

    public List<OfferDTO> loadOffersByMarket(EnumMarketType market) {
        return offersAPI.loadOffersByMarket(market)
                .stream().map(OfferDTO::fromDomain)
                .collect(Collectors.toList());
    }
}
