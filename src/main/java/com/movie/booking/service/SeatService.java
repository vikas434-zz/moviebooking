package com.movie.booking.service;

import com.movie.booking.enums.Status;
import com.movie.booking.exception.SeatAlreadyLockedException;
import com.movie.booking.exception.SeatAlreadyUnLockedException;
import com.movie.booking.exception.SeatNotFoundException;
import com.movie.booking.model.Seat;
import com.movie.booking.model.SeatData;
import com.movie.booking.repository.SeatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;


    public List<Seat> getSeatsById(final UUID showId) {
        return seatRepository.findByShowId(showId);
    }

    public Seat lockSeat(final SeatData seatData) {
        Optional<Seat> seatOptional = validateAndGetSeatData(seatData);
        final Seat seat = seatOptional.get();
        if (Status.LOCKED.name().equalsIgnoreCase(seat.getCurrentStatus())) {
            throw new SeatAlreadyLockedException(String.format("Seat is already locked for the seatId %s",
                                                               seatData.getSeatId()));
        }
        //TODO check available
        seat.setUserId(seatData.getUserId());
        seat.setLockedAt(System.currentTimeMillis());
        seat.setCurrentStatus(Status.LOCKED.name());
        return seatRepository.save(seat);
    }

    public Seat unlockSeat(final SeatData seatData) {
        Optional<Seat> seatOptional = validateAndGetSeatData(seatData);
        final Seat seat = seatOptional.get();
        if (!Status.LOCKED.name().equalsIgnoreCase(seat.getCurrentStatus())) {
            throw new SeatAlreadyUnLockedException(String.format("Seat is already unlocked, current status %s",
                                                                 seat.getCurrentStatus()));
        }
        seat.setCurrentStatus(Status.BOOKED.name());
        seat.setLockedAt(null);
        seat.setUserId(seatData.getUserId());
        return seatRepository.save(seat);
    }


    private Optional<Seat> validateAndGetSeatData(SeatData seatData) {
        Optional<Seat> seatOptional = seatRepository.findById(seatData.getSeatId());
        if (seatOptional.isEmpty()) {
            throw new SeatNotFoundException(String.format("No seat data available for the seatid %s",
                                                          seatData.getSeatId()));
        }
        return seatOptional;
    }

}
