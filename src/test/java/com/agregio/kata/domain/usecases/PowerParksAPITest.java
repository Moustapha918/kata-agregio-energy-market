package com.agregio.kata.domain.usecases;

import com.agregio.kata.domain.powerparks.InvalidTimeBlockEnergyException;
import com.agregio.kata.domain.powerparks.PowerPark;
import com.agregio.kata.domain.powerparks.PowerParks;
import com.agregio.kata.domain.powerparks.TimeBlockEnergy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowerParksAPITest {

    PowerParksAPI sut = new PowerParks();

    @Test
    public void should_not_create_park_invalid_time_block_energy() {

        var functionalException = assertThrows(
                InvalidTimeBlockEnergyException.class,
                () -> sut.create(aParkWithInvalidTimeBlockEnergy())
        );
        assertEquals(
                PwoExceptionMessages.INVALID_TIME_BLOCK_ENERGY_ON_PARK.getCode(),
                functionalException.getMessage()
        );
    }

    @Test
    public void should_create_valid_power_park() {
        var expectedPark = aValidPark();
        expectedPark.setId(1);

        var createdOffer = sut.create(aValidPark()).orElseThrow();
        assertEquals(expectedPark, createdOffer);
    }

    private PowerPark aValidPark() {
        return new PowerPark(1, "park 1", "", List.of(
                new TimeBlockEnergy(0, 3, 230.34D),
                new TimeBlockEnergy(3, 6, 500.34D)
        ));
    }

    private PowerPark aParkWithInvalidTimeBlockEnergy() {
        return new PowerPark(1, "park 1", "", List.of(
                new TimeBlockEnergy(0, 25, 230.34D)
        ));
    }
}
