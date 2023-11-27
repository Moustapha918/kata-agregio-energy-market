package com.agregio.kata.domain.offers;

import com.agregio.kata.domain.market.EnumMarketType;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class Offer {

    private static final int MAX_TIME_BLOCK_PER_OFFER = 24;

    private long id;
    private String name;
    private String Description;
    private EnumMarketType marketType;
    private List<TimeBlock> timeBlocks;

    public Offer(String name, String description, EnumMarketType marketType, List<TimeBlock> timeBlocks) {
        this.name = name;
        Description = description;
        this.marketType = marketType;
        this.timeBlocks = timeBlocks;
    }

    public Offer(long id, String name, String description, EnumMarketType marketType, List<TimeBlock> timeBlocks) {
        this.id = id;
        this.name = name;
        Description = description;
        this.marketType = marketType;
        this.timeBlocks = timeBlocks;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public EnumMarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(EnumMarketType marketType) {
        this.marketType = marketType;
    }

    public List<TimeBlock> getTimeBlocks() {
        return timeBlocks;
    }

    public void setTimeBlocks(List<TimeBlock> timeBlocks) {
        this.timeBlocks = timeBlocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return name.equals(offer.name) && Objects.equals(Description, offer.Description) && marketType == offer.marketType && timeBlocks.equals(offer.timeBlocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Description, marketType, timeBlocks);
    }

    public boolean hasNoTimeBlock() {
        return CollectionUtils.isEmpty(this.getTimeBlocks());
    }

    public boolean hasTooManyTimeBlocks() {
        return this.getTimeBlocks().size() > MAX_TIME_BLOCK_PER_OFFER;
    }

    public boolean hasInvalidTimeBlock() {
        return this.getTimeBlocks().stream().anyMatch(TimeBlock::isValid);
    }
}
