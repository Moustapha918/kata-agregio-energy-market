package com.agregio.kata.domain.offers;

import com.agregio.kata.domain.offers.exceptions.InvalidTimeBlockException;
import com.agregio.kata.domain.offers.exceptions.NoTimeBlockOfferException;
import com.agregio.kata.domain.offers.exceptions.TooManyTimeBlocksOfferException;
import com.agregio.kata.domain.usecases.OffersAPI;
import com.agregio.kata.infrastructure.offers.OffersSPI;

import java.util.Optional;

public class Offers implements OffersAPI {

    private final OffersSPI offersSPI;

    public Offers(OffersSPI offersSPI) {
        this.offersSPI = offersSPI;
    }

    @Override
    public Optional<Offer> createOffer(Offer offer) {
        checkOfferDetails(offer);
        return offersSPI.createOffer(offer);
    }

    private void checkOfferDetails(Offer offer) {
        if (offer.hasNoTimeBlock()) {
            throw new NoTimeBlockOfferException();
        }
        if (offer.hasTooManyTimeBlocks()) {
            throw new TooManyTimeBlocksOfferException();
        }
        if(offer.hasInvalidTimeBlock()){
            throw new InvalidTimeBlockException();
        }
    }
}
