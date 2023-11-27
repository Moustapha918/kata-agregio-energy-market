package com.agregio.kata.domain.usecases;

import com.agregio.kata.domain.powerparks.InvalidTimeBlockEnergyException;
import com.agregio.kata.domain.powerparks.PowerPark;
import com.agregio.kata.domain.powerparks.PowerParks;
import com.agregio.kata.domain.powerparks.TimeBlockEnergy;
import com.agregio.kata.infrastructure.powerparks.PowerParksSPI;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PowerParksAPITest {

    private final PowerParksSPI powerParksSPI = mock(PowerParksSPI.class);
    PowerParksAPI sut = new PowerParks(powerParksSPI);

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

        when(powerParksSPI.create(any())).thenReturn(Optional.of(expectedPark));

        var createdOffer = sut.create(aValidPark()).orElseThrow();
        assertEquals(expectedPark, createdOffer);
    }

    private PowerPark aValidPark() {
        return new PowerPark("park 1", "", List.of(
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
