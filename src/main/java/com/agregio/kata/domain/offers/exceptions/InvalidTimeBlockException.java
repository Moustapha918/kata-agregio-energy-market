package com.agregio.kata.domain.offers.exceptions;

import com.agregio.kata.domain.usecases.PwoFunctionalException;

public class InvalidTimeBlockException extends PwoFunctionalException {
    public InvalidTimeBlockException(String message) {
        super(message);
    }
}
