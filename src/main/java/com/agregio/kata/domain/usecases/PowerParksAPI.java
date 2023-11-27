package com.agregio.kata.domain.usecases;

import com.agregio.kata.domain.powerparks.PowerPark;

import java.util.Optional;

public interface PowerParksAPI {

    Optional<PowerPark> create(PowerPark park);
}
