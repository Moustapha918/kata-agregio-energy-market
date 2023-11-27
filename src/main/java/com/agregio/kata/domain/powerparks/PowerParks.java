package com.agregio.kata.domain.powerparks;

import com.agregio.kata.domain.market.EnumMarketType;
import com.agregio.kata.domain.usecases.OffersAPI;
import com.agregio.kata.domain.usecases.PowerParksAPI;
import com.agregio.kata.domain.usecases.PwoFunctionalException;
import com.agregio.kata.infrastructure.powerparks.PowerParksSPI;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PowerParks implements PowerParksAPI {
    private final PowerParksSPI powerParksSPI;
    private final OffersAPI offersAPI;

    public PowerParks(PowerParksSPI powerParksSPI, OffersAPI offersAPI) {
        this.powerParksSPI = powerParksSPI;
        this.offersAPI = offersAPI;
    }

    @Override
    public Optional<PowerPark> create(PowerPark park) throws PwoFunctionalException {
        checkOnPark(park);
        return powerParksSPI.create(park);
    }

    @Override
    public List<PowerPark> loadParksProvidingOn(EnumMarketType market) {
        var marketOffers = offersAPI.loadOffersByMarket(market);
        List<PowerPark> parks = powerParksSPI.findAllParks();

        return parks.stream().filter(
                park -> park.isProvidingOnOffers(marketOffers)
        ).collect(Collectors.toList());
    }

    private void checkOnPark(PowerPark park) {
        if(park.hasInvalidTimeBlockEnergy()){
            throw new InvalidTimeBlockEnergyException();
        }
    }
}
