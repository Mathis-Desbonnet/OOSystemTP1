package com.tpoosystem.tp1.web;
import com.tpoosystem.tp1.data.Car;
import com.tpoosystem.tp1.data.Dates;
import com.tpoosystem.tp1.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CarService {

    @Autowired
    public RentalService rentalService;

    @GetMapping("/cars")
    List<Car> getAllCars() {
        return rentalService.getAllCars();
    }

    @GetMapping("/cars/{plateNumber}")
    Car getCarFromPlateNumber(@PathVariable("plateNumber") String plateNumber) {
        return rentalService.getCarFromPlateNumber(plateNumber);
    }

    @PutMapping("/cars/{plateNumber}")
    String getCarFromPlateNumber(@PathVariable("plateNumber") String plateNumber, @RequestParam(value = "rent", required = true) boolean rent, @RequestBody Dates dates) {
        return rentalService.getCarFromPlateNumber(plateNumber, rent, dates);
    }


}