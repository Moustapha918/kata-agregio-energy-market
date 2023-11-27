package com.agregio.kata.domain.powerparks;

import com.agregio.kata.domain.usecases.PowerParksAPI;
import com.agregio.kata.domain.usecases.PwoFunctionalException;
import com.agregio.kata.infrastructure.powerparks.PowerParksSPI;

import java.util.Optional;

public class PowerParks implements PowerParksAPI {
    private final PowerParksSPI powerParksSPI;

    public PowerParks(PowerParksSPI powerParksSPI) {
        this.powerParksSPI = powerParksSPI;
    }

    @Override
    public Optional<PowerPark> create(PowerPark park) throws PwoFunctionalException {
        checkOnPark(park);
        return powerParksSPI.create(park);
    }

    private void checkOnPark(PowerPark park) {
        if(park.hasInvalidTimeBlockEnergy()){
            throw new InvalidTimeBlockEnergyException();
        }
    }
}
