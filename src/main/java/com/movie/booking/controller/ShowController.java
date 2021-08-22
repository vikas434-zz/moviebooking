package com.movie.booking.controller;

import com.movie.booking.model.Seat;
import com.movie.booking.model.SeatData;
import com.movie.booking.service.SeatService;
import com.movie.booking.service.ShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;

/**
 * @author vranjan
 * created 21/08/2021
 */
@RestController
@RequestMapping("/v1/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @Autowired
    private SeatService seatService;


    @GetMapping("/getSeatsByShowId/{showId}")
    public List<Seat> getSeatsByShowId(@NonNull @PathVariable UUID showId) {
        return seatService.getSeatsById(showId);
    }

    @PutMapping("/lockSeatForFiveMin")
    public Seat lockSeatForFiveMin(@NonNull @RequestBody SeatData seatData) {
        return seatService.lockSeat(seatData);
    }

    @PutMapping("/unlockSeat")
    @ApiOperation(value = "To be called only after the payment is done")
    public Seat unlockSeat(@RequestBody SeatData seatData) {
        return seatService.unlockSeat(seatData);
    }

}
