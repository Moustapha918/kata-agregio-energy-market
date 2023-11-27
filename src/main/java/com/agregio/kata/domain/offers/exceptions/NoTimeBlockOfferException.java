package com.agregio.kata.domain.offers.exceptions;

import com.agregio.kata.domain.usecases.PwoExceptionMessages;
import com.agregio.kata.domain.usecases.PwoFunctionalException;

public class NoTimeBlockOfferException extends PwoFunctionalException {
    public NoTimeBlockOfferException() {
        super(PwoExceptionMessages.NO_TIME_BLOCK_OFFER_ERROR.getCode());
    }
}
