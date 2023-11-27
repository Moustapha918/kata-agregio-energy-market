package com.agregio.kata.infrastructure;

import com.agregio.kata.domain.offers.Offers;
import com.agregio.kata.domain.powerparks.PowerParks;
import com.agregio.kata.domain.usecases.OffersAPI;
import com.agregio.kata.domain.usecases.PowerParksAPI;
import com.agregio.kata.infrastructure.offers.OffersSPI;
import com.agregio.kata.infrastructure.powerparks.PowerParksSPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainInjections {
    @Bean
    public OffersAPI createOffersAPI(OffersSPI offersSPI){
        return new Offers(offersSPI);
    }

    @Bean public PowerParksAPI createPowerParksAPI(PowerParksSPI powerParksSPI){
        return new PowerParks(powerParksSPI);
    }
}
