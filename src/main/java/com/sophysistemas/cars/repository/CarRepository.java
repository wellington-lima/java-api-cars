package com.sophysistemas.cars.repository;

import org.springframework.data.repository.CrudRepository;
import com.sophysistemas.cars.model.CarModel;

public interface CarRepository extends CrudRepository<CarModel, Integer> {}
