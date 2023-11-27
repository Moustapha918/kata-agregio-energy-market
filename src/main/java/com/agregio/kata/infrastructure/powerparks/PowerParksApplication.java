package com.agregio.kata.infrastructure.powerparks;

import com.agregio.kata.domain.usecases.PowerParksAPI;
import org.springframework.stereotype.Component;

@Component
public class PowerParksApplication {
    private final PowerParksAPI powerParksAPI;

    public PowerParksApplication(PowerParksAPI powerParksAPI) {
        this.powerParksAPI = powerParksAPI;
    }
    public PowerParkDTO create(PowerParkDTO powerParkToCreate) {
        var created = powerParksAPI.create(powerParkToCreate.toDomain())
                .orElseThrow();
        return PowerParkDTO.fromDomain(created);
    }
}
