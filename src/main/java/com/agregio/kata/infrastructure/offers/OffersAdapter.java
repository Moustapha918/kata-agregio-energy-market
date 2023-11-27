package com.agregio.kata.infrastructure.offers;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.offers.Offer;
import com.agregio.kata.domain.offers.TimeBlock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OffersAdapter implements OffersSPI {

    private List<Offer> dataBase = this.initDB();

    @Override
    public Optional<Offer> createOffer(Offer offer) {
        offer.setId(dataBase.size() + 1);
        dataBase.add(offer);
        return Optional.of(offer);
    }

    @Override
    public List<Offer> loadOffers() {
        return dataBase;
    }

    private List<Offer> initDB() {

        return new ArrayList<>(List.of(
                new Offer(1, "with 2 block", "",
                        EnumMarketType.PRIMARY_RESERVE, List.of(
                        new TimeBlock(1, 0, 3, 30.4D, 50D),
                        new TimeBlock(2, 0, 4, 40D, 64D))
                ),
                new Offer(2, "with 2 block", "",
                        EnumMarketType.SECONDARY_RESERVE, List.of(
                        new TimeBlock(1, 0, 3, 30.4D, 50D),
                        new TimeBlock(2, 0, 4, 40D, 64D))
                )
        ));
    }
}
