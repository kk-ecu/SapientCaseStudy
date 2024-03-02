package com.sapient.repository;

import com.sapient.entity.Address;
import com.sapient.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
public interface CityRepository extends CrudRepository<City, UUID> {
}
