package com.agregio.kata.domain.usecases;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.offers.Offer;

import java.util.List;
import java.util.Optional;

public interface OffersAPI {

    Optional<Offer> createOffer(Offer offer) throws PwoFunctionalException;

    List<Offer> loadOffersByMarket(EnumMarketType primaryReserve);
}
