package com.agregio.kata.infrastructure.offers;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.offers.Offer;

import java.util.List;
import java.util.stream.Collectors;

public record OfferCreationDTO(String name,
                               String description,
                               EnumMarketType marketType,
                               List<TimeBlockDTO> timeBlocks) {
    public Offer toDomain() {
        return new Offer(name,
                description,
                marketType,
                timeBlocks.stream().map(TimeBlockDTO::toDomain)
                        .collect(Collectors.toList()));
    }
}
