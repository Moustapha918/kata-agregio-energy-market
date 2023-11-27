package com.agregio.kata.infrastructure.offers;


import com.agregio.kata.domain.offers.TimeBlock;

public record TimeBlockDTO (
        int startHour,
        int endHour,
        Double floorPrice,
        Double powerQuantity
) {
    public TimeBlock toDomain() {
        return new TimeBlock(startHour, endHour, floorPrice, powerQuantity);
    }

    public static TimeBlockDTO fromDomain(TimeBlock timeBlock) {
        return new TimeBlockDTO(timeBlock.getStartHour(),
                timeBlock.getEndHour(),
                timeBlock.getFloorPrice(),
                timeBlock.getPowerQuantity());
    }
}
