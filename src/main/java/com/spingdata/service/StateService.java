package com.spingdata.service;

import com.spingdata.entity.City;

import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
public interface CityService {

    City get(UUID uuid) throws Exception;
    List<City> search(String pattern);
    List<City> getAll();
    City save(City movie);
    City update(City movie);
    boolean delete(UUID id) throws Exception;
}
