package com.movie.booking.exception;

/**
 * @author vranjan
 * created 21/08/2021
 */
public class SeatAlreadyLockedException extends RuntimeException {
    public SeatAlreadyLockedException(String message) {
        super(message);
    }
}
