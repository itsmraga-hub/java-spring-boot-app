package com.example.demoamigoscode.repositories;

import com.example.demoamigoscode.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
