package com.movie.booking.repository;

import com.movie.booking.model.Seat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {

    List<Seat> findByShowId(final UUID showId);

    List<Seat> findByLockedAtBefore(final long time);
}
