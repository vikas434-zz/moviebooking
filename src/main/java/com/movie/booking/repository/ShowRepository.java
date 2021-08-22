package com.movie.booking.repository;

import com.movie.booking.model.Show;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Repository
public interface ShowRepository extends CrudRepository<Show, Integer> {
}
