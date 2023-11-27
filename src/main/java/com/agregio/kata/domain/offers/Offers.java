package com.agregio.kata.domain.offers;

import com.agregio.kata.domain.usecases.OffersAPI;

import java.util.Optional;

public class Offers implements OffersAPI {
    @Override
    public Optional<Offer> createOffer(Offer offer) throws Exception {
        return Optional.empty();
    }
}
