package com.movie.booking.service;

import com.movie.booking.model.Show;
import com.movie.booking.repository.ShowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vranjan
 * created 21/08/2021
 */
@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show addShow(final Show show) {
        validateShowData(show);
        return showRepository.save(show);
    }

    private void validateShowData(final Show show) {
        //TODO custom validations and throw exceptions if any.
    }
}
