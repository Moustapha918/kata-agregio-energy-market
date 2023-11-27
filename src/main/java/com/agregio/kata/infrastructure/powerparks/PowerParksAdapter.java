package com.agregio.kata.infrastructure.powerparks;

import com.agregio.kata.domain.powerparks.PowerPark;

import com.agregio.kata.domain.powerparks.TimeBlockEnergy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PowerParksAdapter implements PowerParksSPI {
    private List<PowerPark> database = initDB();

    @Override
    public Optional<PowerPark> create(PowerPark park) {
        park.setId(database.size() + 1);
        database.add(park);
        return Optional.of(park);
    }

    private List<PowerPark> initDB() {
        return new ArrayList<>(
                List.of(
                        new PowerPark(1, "park 1", "12 rue de la vilette",
                                List.of(new TimeBlockEnergy(1, 3, 123.4D)
                                )),
                        new PowerPark(2, "park 1", "12 rue de la vilette",
                                List.of(new TimeBlockEnergy(4, 6, 453.4D)
                                ))
                )
        );
    }
}
