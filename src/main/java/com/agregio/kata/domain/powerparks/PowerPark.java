package com.agregio.kata.domain.powerparks;

import java.util.List;

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
}
