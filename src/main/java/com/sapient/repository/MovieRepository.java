package com.sapient.repository;

import com.sapient.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, UUID> {
}
