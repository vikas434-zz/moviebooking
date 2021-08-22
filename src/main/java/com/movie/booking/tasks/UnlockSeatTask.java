package com.movie.booking.tasks;

import com.movie.booking.model.Seat;
import com.movie.booking.repository.SeatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.ObjectInputFilter;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Slf4j
@Component
public class UnlockSeatTask {

    private static final long FIVE_MINUTE = 5 * 60 * 1000L;

    private static final long EVERY_MINUTE = 1 * 60 * 1000L;

    @Autowired
    private SeatRepository seatRepository;

    @Scheduled(fixedRate = EVERY_MINUTE)
    public void reportCurrentTime() {
        log.info("The time is now {}", new Date());
        List<Seat> seatList = seatRepository.findByLockedAtBefore(getTime());
        if(seatList.isEmpty()) {
            return;
        }
        seatList.forEach(s->{
            // if(s.getCurrentStatus().equalsIgnoreCase(Status.))
        });

    }

    private long getTime() {
        return System.currentTimeMillis() - FIVE_MINUTE;
    }
}
