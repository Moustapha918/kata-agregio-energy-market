package com.agregio.kata.infrastructure;

import com.agregio.kata.domain.offers.Offers;
import com.agregio.kata.domain.usecases.OffersAPI;
import com.agregio.kata.infrastructure.offers.OffersSPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainInjections {
    @Bean
    public OffersAPI createOffersAPI(OffersSPI offersSPI){
        return new Offers(offersSPI);
    }
}
