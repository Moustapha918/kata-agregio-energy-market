package com.agregio.kata.domain.offers;

import java.util.Objects;

public class TimeBlock {

    private long id;
    private int startHour;
    private int endHour;
    private Double floorPrice;
    private Double powerQuantity;

    public TimeBlock(int startHour, int endHour, Double floorPrice, Double powerQuantity) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.floorPrice = floorPrice;
        this.powerQuantity = powerQuantity;
    }

    public TimeBlock(long id, int startHour, int endHour, Double floorPrice, Double powerQuantity) {
        this.id = id;
        this.startHour = startHour;
        this.endHour = endHour;
        this.floorPrice = floorPrice;
        this.powerQuantity = powerQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Double getPowerQuantity() {
        return powerQuantity;
    }

    public void setPowerQuantity(Double powerQuantity) {
        this.powerQuantity = powerQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeBlock timeBlock = (TimeBlock) o;
        return id == timeBlock.id && startHour == timeBlock.startHour &&
                endHour == timeBlock.endHour && floorPrice.equals(timeBlock.floorPrice) &&
                powerQuantity.equals(timeBlock.powerQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startHour, endHour, floorPrice, powerQuantity);
    }

    public boolean isValid() {
        return startHour >= 0 && startHour < 24
                && endHour >= 0 &&  endHour < 24;
    }
}
