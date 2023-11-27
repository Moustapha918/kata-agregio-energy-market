package com.agregio.kata.domain.offers.exceptions;

import com.agregio.kata.domain.usecases.PwoFunctionalException;

public class TooManyTimeBlocksOfferException extends PwoFunctionalException {
    public TooManyTimeBlocksOfferException(String message) {
        super(message);
    }
}
