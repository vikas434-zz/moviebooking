package com.movie.booking.model;

import java.util.Date;
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
@Entity(name = "show")
public class Show {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID showId;

    @Column(name = "name")
    private String showName;

    @Column(name = "location")
    private String showLocation;

    @Column(name = "start_time")
    private Date showStartTiming;

    @Column(name = "total_seats")
    private int totalSeats;
}
