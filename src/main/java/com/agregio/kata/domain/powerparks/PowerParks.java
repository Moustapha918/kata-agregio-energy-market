package com.agregio.kata.domain.powerparks;

import com.agregio.kata.domain.usecases.PowerParksAPI;

import java.util.Optional;

public class PowerParks implements PowerParksAPI {
    @Override
    public Optional<PowerPark> create(PowerPark park) {
        return Optional.empty();
    }
}
