package com.tpoosystem.tp1.service;

import com.tpoosystem.tp1.data.Car;
import com.tpoosystem.tp1.data.Dates;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RentalService {

    List<Car> getAllCars();
    Car getCarFromPlateNumber(String plateNumber) ;
    String getCarFromPlateNumber(@PathVariable("plateNumber") String plateNumber, @RequestParam(value = "rent", required = true) boolean rent, @RequestBody Dates dates);

}
