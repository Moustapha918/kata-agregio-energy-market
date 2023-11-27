package com.agregio.kata.domain.offers.exceptions;

import com.agregio.kata.domain.usecases.PwoExceptionMessages;
import com.agregio.kata.domain.usecases.PwoFunctionalException;

public class InvalidTimeBlockException extends PwoFunctionalException {
    public InvalidTimeBlockException() {
        super(PwoExceptionMessages.TIME_BLOCKS_LIMITS_ERROR.getCode());
    }
}
