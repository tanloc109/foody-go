package com.foodygo.shipping.exception;

public class ShipperInactiveException extends RuntimeException {
    public ShipperInactiveException(String message) {
        super(message);
    }
}
