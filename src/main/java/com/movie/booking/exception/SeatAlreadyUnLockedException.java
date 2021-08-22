package com.movie.booking.exception;

/**
 * @author vranjan
 * created 21/08/2021
 */
public class SeatAlreadyUnLockedException extends RuntimeException {
    public SeatAlreadyUnLockedException(String message) {
        super(message);
    }
}
