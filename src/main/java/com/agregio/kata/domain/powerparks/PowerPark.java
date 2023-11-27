package com.agregio.kata.domain.powerparks;

import java.util.List;
import java.util.Objects;

public class PowerPark {
    private long id;
    private String name;
    private String address;
    private List<TimeBlockEnergy> timeBlockEnergies;

    public PowerPark(long id, String name, String address, List<TimeBlockEnergy> timeBlockEnergies) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.timeBlockEnergies = timeBlockEnergies;
    }

    public PowerPark(String name, String address, List<TimeBlockEnergy> timeBlockEnergies) {
        this.name = name;
        this.address = address;
        this.timeBlockEnergies = timeBlockEnergies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TimeBlockEnergy> getTimeBlockEnergies() {
        return timeBlockEnergies;
    }

    public void setTimeBlockEnergies(List<TimeBlockEnergy> timeBlockEnergies) {
        this.timeBlockEnergies = timeBlockEnergies;
    }

    public boolean hasInvalidTimeBlockEnergy() {
        return this.timeBlockEnergies.stream().anyMatch(
                timeBlockEnergy -> !timeBlockEnergy.isValid()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerPark powerPark = (PowerPark) o;
        return id == powerPark.id && name.equals(powerPark.name) && Objects.equals(address, powerPark.address) && timeBlockEnergies.equals(powerPark.timeBlockEnergies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, timeBlockEnergies);
    }
}
