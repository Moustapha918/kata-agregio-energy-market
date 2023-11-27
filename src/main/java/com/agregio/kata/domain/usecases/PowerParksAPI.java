package com.agregio.kata.domain.usecases;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.powerparks.PowerPark;

import java.util.List;
import java.util.Optional;

public interface PowerParksAPI {

    Optional<PowerPark> create(PowerPark park);

    List<PowerPark> loadParksProvidingOn(EnumMarketType primaryReserve);
}
