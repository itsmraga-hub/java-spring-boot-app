package com.example.demoamigoscode.controllers;

import com.example.demoamigoscode.models.Address;
import com.example.demoamigoscode.repositories.AddressRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("api/v1/addresses")
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

//    public record NewAddressRequest(String location, String street, String city) {
//
//    }

    public Iterable<Address> getAddresses() {
        return addressRepository.findAll();
    }

//    @PostMapping
//    public void addAddress(@RequestBody NewAddressRequest request) {
//
//    }
}
