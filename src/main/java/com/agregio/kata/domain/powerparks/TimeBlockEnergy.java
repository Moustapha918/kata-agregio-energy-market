package com.agregio.kata.domain.powerparks;

public class TimeBlockEnergy {

    private int startHour;
    private int endHour;
    private Double providedEnergy;

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public Double getProvidedEnergy() {
        return providedEnergy;
    }

    public void setProvidedEnergy(Double providedEnergy) {
        this.providedEnergy = providedEnergy;
    }

    public TimeBlockEnergy(int startHour, int endHour, Double providedEnergy) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.providedEnergy = providedEnergy;
    }

    public boolean isValid() {
        return startHour >= 0 && startHour < 24
                && endHour >= 0 && endHour < 24;
    }
}
