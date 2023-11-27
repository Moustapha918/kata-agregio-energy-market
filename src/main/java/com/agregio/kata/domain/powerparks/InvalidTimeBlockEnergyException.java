package com.agregio.kata.domain.powerparks;

import com.agregio.kata.domain.usecases.PwoFunctionalException;

import static com.agregio.kata.domain.usecases.PwoExceptionMessages.INVALID_TIME_BLOCK_ENERGY_ON_PARK;

public class InvalidTimeBlockEnergyException extends PwoFunctionalException {
    public InvalidTimeBlockEnergyException() {
        super(INVALID_TIME_BLOCK_ENERGY_ON_PARK.getCode());
    }
}
