package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
