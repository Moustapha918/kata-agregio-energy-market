package com.agregio.kata.infrastructure.offers;

import com.agregio.kata.domain.offers.Offer;

import java.util.List;
import java.util.Optional;

public interface OffersSPI {
    Optional<Offer> createOffer(Offer offer);

    List<Offer> loadOffers();
}
