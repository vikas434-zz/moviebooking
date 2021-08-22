package com.movie.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vranjan
 * created 21/08/2021
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeatNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SeatNotFoundException(String message) {
        super(message);
    }
}
