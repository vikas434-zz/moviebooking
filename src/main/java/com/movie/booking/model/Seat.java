package com.movie.booking.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Data
@Entity(name = "seat")
public class Seat {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int seatId;

    @Column(name = "show_id")
    private UUID showId;

    @Column(name = "row_no")
    private String rowNo;

    @Column(name = "column_no")
    private String columnNo;

    @Column(name = "status")
    private String currentStatus; // Currently string to be replaced by enum(BOOKED, LOCKED, AVAILABLE)

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "locked_at")
    private Long lockedAt; // Epoch timestamp when it was locked.
}
