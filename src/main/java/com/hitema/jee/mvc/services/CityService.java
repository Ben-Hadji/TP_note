package com.hitema.jee.mvc.services;

import com.hitema.jee.mvc.entities.City;
import com.hitema.jee.mvc.entities.Country;

import java.util.List;

public interface CityService {
    List<City> readAll() ;

    City create(City City);
}
