package com.pragma.foodcourt.domain.exception;

/**
 * Model exception handler class
 */
public class DomainException extends RuntimeException {

    /**
     *
     * @param message print message exception
     */
    public DomainException(String message) {
        super(message);
    }
}
