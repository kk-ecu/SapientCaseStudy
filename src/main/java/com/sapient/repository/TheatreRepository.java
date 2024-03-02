package com.sapient.repository;

import com.sapient.entity.Address;
import com.sapient.entity.Theatre;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
public interface TheatreRepository extends CrudRepository<Theatre, UUID> {
}
