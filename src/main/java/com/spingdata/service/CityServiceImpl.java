package com.sapient.service;

import com.sapient.entity.City;
import com.sapient.repository.CityRepository;
import com.sapient.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Service
public class CityServiceImpl implements CityService{

    private CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City get(UUID uuid) throws Exception {
        Optional<City>city=this.cityRepository.findById(uuid);
        if (city.isPresent()){
            throw new Exception("No City is Available");
        }
        return city.get();
    }

    @Override
    public List<City> search(String pattern) {
        Iterable<City> iterable= this.cityRepository.findAll();
        List<City> cities=new ArrayList<>();

        iterable.forEach(city -> {
            if (city.getName().contains(pattern)) {
                cities.add(city);
            }
            });
        return cities;
    }

    @Override
    public List<City> getAll() {
        List<City> cities=new ArrayList<>();
        this.cityRepository.findAll().forEach(cities::add);
    return cities;
    }

    @Override
    public City save(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public City update(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        this.cityRepository.delete(this.get(id));
        return true ;
    }
}
