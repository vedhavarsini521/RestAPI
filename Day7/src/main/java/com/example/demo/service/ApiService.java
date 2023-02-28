package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;

import com.example.demo.repository.CarRepo;

@RestController

public class ApiService {

@Autowired

CarRepo repository;

public boolean addCar(Car car) {

repository.save(car);

return true;

}

public List<Car> getOwners(int owners){

return repository.findByOwners(owners);

}

public List<Car> getAddress(String address){

return repository.findByAddress(address);

}

public List<Car> getCarName(String carName){

return repository.findByCarName(carName);

}

public List<Car> getOwnersOrCarType(int owners,String carType){

return repository.findByOwnersOrCarType(owners,carType);

}

public List<Car> getOwnersAndCarType(int owners,String carType){

return repository.findByOwnersAndCarType(owners,carType);

}

}