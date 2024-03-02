package com.sapient.repository;

import com.sapient.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, UUID> {
}
