package com.agregio.kata.infrastructure.offers;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.offers.Offer;

import java.util.List;
import java.util.stream.Collectors;

public record OfferDTO(
        long id,
        String name,
        String Description,
        EnumMarketType marketType,
        List<TimeBlockDTO> timeBlocks
) {
    public static OfferDTO fromDomain(Offer offer) {
        var timeBlocks = offer.getTimeBlocks().stream()
                .map(TimeBlockDTO::fromDomain)
                .collect(Collectors.toList());

        return new OfferDTO(offer.getId(),
                offer.getName(),
                offer.getDescription(),
                offer.getMarketType(),
                timeBlocks);
    }

}
