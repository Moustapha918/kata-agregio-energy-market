package com.agregio.kata.infrastructure.powerparks;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.agregio.kata.infrastructure.WebConstants.API_ROOT_URL;


@RestController
public class PowerParksController {

    private final PowerParksApplication powerParksApplication;

    public PowerParksController(PowerParksApplication powerParksApplication) {
        this.powerParksApplication = powerParksApplication;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = API_ROOT_URL + "/parks")
    public ResponseEntity<PowerParkDTO> createPowerPark(@RequestBody PowerParkDTO powerParkToCreate) {

        var createdPark = powerParksApplication.create(powerParkToCreate);
        return ResponseEntity.ok(createdPark);
    }

}
