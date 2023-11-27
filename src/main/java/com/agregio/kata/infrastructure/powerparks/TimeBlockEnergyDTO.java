package com.agregio.kata.infrastructure.powerparks;

import com.agregio.kata.domain.powerparks.TimeBlockEnergy;

public record TimeBlockEnergyDTO(int startHour, int endHour, Double providedEnergy) {
    public static TimeBlockEnergyDTO fromDomain(TimeBlockEnergy timeBlockEnergy) {
        return new TimeBlockEnergyDTO(timeBlockEnergy.getStartHour(),
                timeBlockEnergy.getEndHour(),
                timeBlockEnergy.getProvidedEnergy());
    }

    public TimeBlockEnergy toDomain() {
        return new TimeBlockEnergy(startHour, endHour, providedEnergy);
    }
}
