package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;

import com.example.demo.service.ApiService;

@RestController

public class ApiController {

@Autowired

ApiService service;

@PostMapping("/car")

public boolean addCar(@RequestBody Car car) {

return service.addCar(car);

}

@GetMapping("/car/owners/{owners}")

public List<Car> getOwners(@PathVariable int owners){

return service.getOwners(owners);

}

@GetMapping("/car/address/{address}")

public List<Car> getAddress(@PathVariable String address){

return service.getAddress(address);

}

@GetMapping("/car/carname/{carName}")

public List<Car> getCarName(@PathVariable String carName){

return service.getCarName(carName);

}

@GetMapping("/car/ownersorcartype/{owners}/{carType}")

public List<Car> getOwnersOrCarType(@PathVariable int owners,@PathVariable String carType){

return service.getOwnersOrCarType(owners, carType);

}

@GetMapping("/car/ownersandcartype/{owners}/{carType}")

public List<Car> getOwnersAndCarType(@PathVariable int owners,@PathVariable String carType){

return service.getOwnersAndCarType(owners, carType);

}

}