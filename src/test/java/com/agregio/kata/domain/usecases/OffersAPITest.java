package com.agregio.kata.domain.usecases;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.offers.Offer;
import com.agregio.kata.domain.offers.Offers;
import com.agregio.kata.domain.offers.TimeBlock;
import com.agregio.kata.domain.offers.exceptions.InvalidTimeBlockException;
import com.agregio.kata.domain.offers.exceptions.NoTimeBlockOfferException;
import com.agregio.kata.domain.offers.exceptions.TooManyTimeBlocksOfferException;
import com.agregio.kata.infrastructure.offers.OffersSPI;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OffersAPITest {

    private final OffersSPI offersSPI = mock(OffersSPI.class);
    private final OffersAPI sut = new Offers(offersSPI);

    @Test
    public void should_not_create_offer_without_time_block() {
        Offer voidOffer = new Offer("void offer", "", EnumMarketType.PRIMARY_RESERVE, List.of());
        var functionalException = assertThrows(NoTimeBlockOfferException.class, () -> sut.createOffer(voidOffer));
        assertEquals(PwoExceptionMessages.NO_TIME_BLOCK_OFFER_ERROR.getCode(), functionalException.getMessage());
    }

    @Test
    public void should_not_create_offers_with_more_than_24_time_blocks() {
        var functionalException = assertThrows(TooManyTimeBlocksOfferException.class, () -> sut.createOffer(offerWithTooManyBlocks()));
        assertEquals(PwoExceptionMessages.TOO_MANY_TIME_BLOCKS_OFFER_ERROR.getCode(), functionalException.getMessage());
    }

    @Test
    public void should_not_create_offer_with_wrong_time_blocks() {
        var functionalException = assertThrows(InvalidTimeBlockException.class, () -> sut.createOffer(offerWithWrongTimeBlocks()));
        assertEquals(PwoExceptionMessages.TIME_BLOCKS_LIMITS_ERROR.getCode(), functionalException.getMessage());
    }

    @Test
    public void should_create_a_valid_offer(){
        var expectedOffer = aValidOffer();
        expectedOffer.setId(1);
        when(offersSPI.createOffer(aValidOffer())).thenReturn(Optional.of(expectedOffer));

        var createdOffer = sut.createOffer(aValidOffer()).orElseThrow();
        assertEquals(expectedOffer, createdOffer);
    }

    @Test
    public void should_load_primary_reserve_market_offers() {

        when(offersSPI.loadOffers()).thenReturn(lotOfOffers());
        var expectedOffers = sut.loadOffersByMarket(EnumMarketType.PRIMARY_RESERVE);
        assertEquals(1, expectedOffers.size());
    }

    private Offer aValidOffer() {
        return new Offer("with 24 block", "",
                EnumMarketType.PRIMARY_RESERVE, List.of(
                new TimeBlock(0, 4, 300D, 1200D),
                new TimeBlock(4, 8, 250D, 900D)
        ));
    }

    public List<Offer> lotOfOffers() {
        return List.of(
                new Offer("with 24 block", "",
                        EnumMarketType.PRIMARY_RESERVE, List.of(
                        new TimeBlock(0, 4, 300D, 1200D),
                        new TimeBlock(4, 8, 250D, 900D)
                )),
                new Offer("with 24 block", "",
                        EnumMarketType.SECONDARY_RESERVE, List.of(
                        new TimeBlock(0, 4, 300D, 1200D),
                        new TimeBlock(4, 8, 250D, 900D)
                )),
                new Offer("with 24 block", "",
                        EnumMarketType.QUICK_RESERVE, List.of(
                        new TimeBlock(0, 4, 300D, 1200D),
                        new TimeBlock(4, 8, 250D, 900D)
                ))

        );

    }

    private Offer offerWithWrongTimeBlocks() {
        return new Offer("with 24 block", "",
                EnumMarketType.PRIMARY_RESERVE, List.of(
                new TimeBlock(0, 4, 300D, 1200D),
                new TimeBlock(30, 22, 250D, 900D),
                new TimeBlock(14, 3, 490D, 340D))
        );
    }

    private Offer offerWithTooManyBlocks() {
        return new Offer("with 24 block", "",
                EnumMarketType.PRIMARY_RESERVE, List.of(
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D),
                new TimeBlock(0, 3, 30.4D, 50D)

        ));
    }

}

