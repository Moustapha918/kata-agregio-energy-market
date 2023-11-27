package com.agregio.kata.domain.offers.exceptions;

import com.agregio.kata.domain.usecases.PwoExceptionMessages;
import com.agregio.kata.domain.usecases.PwoFunctionalException;

public class TooManyTimeBlocksOfferException extends PwoFunctionalException {
    public TooManyTimeBlocksOfferException() {
        super(PwoExceptionMessages.TOO_MANY_TIME_BLOCKS_OFFER_ERROR.getCode());
    }
}
