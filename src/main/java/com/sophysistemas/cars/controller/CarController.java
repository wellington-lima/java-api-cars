package com.sophysistemas.cars.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sophysistemas.cars.model.CarModel;
import com.sophysistemas.cars.repository.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@GetMapping(path = "/api/cars/{id}")
	public Optional<CarModel> getCarById(@PathVariable("id") Integer id) {
		return carRepository.findById(id);
	}
	
	@GetMapping(path = "/api/cars")
	public Iterable<CarModel> getCar() {
		return carRepository.findAll();
	}
	
	@PostMapping(path = "/api/cars")
	public CarModel save(@RequestBody CarModel car) {
		return carRepository.save(car);
	}
	
	@PutMapping(path = "/api/cars/{id}")
	public ResponseEntity<CarModel> update(@PathVariable("id") Integer id,  @RequestBody CarModel car) {
		
		CarModel carInDb = carRepository.findById(id).get();
			
		carInDb.manufacturer = car.getManufacturer();
		carInDb.model = car.getModel();
		carInDb.price = car.getPrice();
		
		carRepository.save(carInDb);
	
		return ResponseEntity.ok(carInDb);
	}
	
	@DeleteMapping(path = "/api/cars/{id}")
	public void delete(@PathVariable("id") Integer id) {
		carRepository.deleteById(id);
	}
}
