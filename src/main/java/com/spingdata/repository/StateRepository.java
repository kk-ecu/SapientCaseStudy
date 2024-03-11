package com.sapient.repository;

import com.sapient.entity.Address;
import com.sapient.entity.Screen;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
public interface StateRepository extends CrudRepository<Screen, UUID> {
}
