package com.agregio.kata.infrastructure.powerparks;

import com.agregio.kata.domain.powerparks.PowerPark;

import java.util.List;
import java.util.stream.Collectors;

public record PowerParkDTO(long id,
                           String name,
                           String address,
                           List<TimeBlockEnergyDTO> timeBlockEnergies) {
    public static PowerParkDTO fromDomain(PowerPark park) {
        return new PowerParkDTO(park.getId(), park.getName(), park.getAddress(), park.getTimeBlockEnergies().stream()
                .map(TimeBlockEnergyDTO::fromDomain)
                .collect(Collectors.toList()));
    }

    public PowerPark toDomain() {
        return new PowerPark(name, address, timeBlockEnergies.stream()
                .map(TimeBlockEnergyDTO::toDomain).collect(Collectors.toList()));
    }
}
