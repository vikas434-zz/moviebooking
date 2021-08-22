package com.movie.booking.model;

import java.util.UUID;

import lombok.Data;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Data
public class SeatData {
    private int seatId;

    private UUID userId;
}
