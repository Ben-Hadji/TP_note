package com.hitema.jee.mvc.controllers;

import com.hitema.jee.mvc.entities.City;
import com.hitema.jee.mvc.entities.Country;
import com.hitema.jee.mvc.services.CityService;
import com.hitema.jee.mvc.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CityController {
    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/cities")
    public ModelAndView getAll(){
        log.trace("Cities Get All called ...");
        var view = new ModelAndView();
        view.addObject("mmsg","autres attribut");
        view.addObject("cities",service.readAll());
        return view;
    }
    @GetMapping("/cityModify")
    public ModelAndView getcityModify() {
        log.trace("Appel getcityModify city");
        City city = new City();
        city.setLastUpdate(LocalDateTime.now());
        return new ModelAndView("cityModify","city",city);
    }

    @PostMapping("/cityModify")
    public ModelAndView cityModify(@ModelAttribute("cityForm") City city, ModelMap model) {
        log.trace("Appel cityModify : {} ", city);
        service.create(city);
        return new ModelAndView("cityModify","city",city);
    }

    private CityService cityService;
    private CountryService countryService;


}
