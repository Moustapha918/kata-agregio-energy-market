package com.agregio.kata.domain.offers.exceptions;

import com.agregio.kata.domain.usecases.PwoFunctionalException;

public class NoTimeBlockOfferException extends PwoFunctionalException {
    public NoTimeBlockOfferException(String message) {
        super(message);
    }
}
