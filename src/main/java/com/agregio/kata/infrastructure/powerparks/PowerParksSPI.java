package com.agregio.kata.infrastructure.powerparks;

import com.agregio.kata.domain.powerparks.PowerPark;
import com.agregio.kata.domain.usecases.PwoFunctionalException;

import java.util.Optional;

public interface PowerParksSPI {
    Optional<PowerPark> create(PowerPark park) throws PwoFunctionalException;
}
