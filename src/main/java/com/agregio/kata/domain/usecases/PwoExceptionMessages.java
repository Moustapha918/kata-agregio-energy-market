package com.agregio.kata.domain.usecases;

public enum PwoExceptionMessages {

    TOO_MANY_TIME_BLOCKS_OFFER_ERROR("offer-has-too-many-time-blocks"),
    NO_TIME_BLOCK_OFFER_ERROR("offer-has-no-time-block"),
    TIME_BLOCKS_LIMITS_ERROR("time-block-has-wrong-limits"),
    INVALID_TIME_BLOCK_ENERGY_ON_PARK("park-with-invalid-time-block-energy");
    private final String code;

    PwoExceptionMessages(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
