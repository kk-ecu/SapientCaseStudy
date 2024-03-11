package com.sapient.controller;


import com.sapient.entity.City;
import com.sapient.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@RestController
@RequestMapping("api/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService movieService) {
        this.cityService = cityService;
    }

    @GetMapping
    @RequestMapping("/{uuid}")
    ResponseEntity<City> read(@PathVariable("uuid") String uuid)  {
        City city=null;
        try
        {
            city=this.cityService.get(UUID.fromString(uuid));
            return  new ResponseEntity<City>(city, null, HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<City>(city,null,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    City create(@RequestBody City city){
        city=this.cityService.save(city);
        return  city;
    }

    @GetMapping
    @RequestMapping("/all")
    List<City> getAll(){
        return this.cityService.getAll();
    }



    @GetMapping
    @RequestMapping("/search")
    List<City> search(String pattern){
        return this.cityService.search(pattern);
    }

    @PutMapping
    @RequestMapping("/")
    City update(City city){
        city=this.cityService.update(city);
        return  city;
    }

}
