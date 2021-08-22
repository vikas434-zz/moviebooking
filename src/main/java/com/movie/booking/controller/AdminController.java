package com.movie.booking.controller;

import com.movie.booking.model.Show;
import com.movie.booking.service.ShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vranjan
 * created 21/08/2021
 */
@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public Show addShow(@RequestBody Show show) {
        return showService.addShow(show);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }
}
