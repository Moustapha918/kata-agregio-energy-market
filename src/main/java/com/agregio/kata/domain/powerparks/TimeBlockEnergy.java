package com.agregio.kata.domain.powerparks;

public class TimeBlockEnergy {

    private int startHour;
    private int endHour;
    private double providedEnergy;

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

    public double getProvidedEnergy() {
        return providedEnergy;
    }

    public void setProvidedEnergy(double providedEnergy) {
        this.providedEnergy = providedEnergy;
    }

    public TimeBlockEnergy(int startHour, int endHour, double providedEnergy) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.providedEnergy = providedEnergy;
    }
}
