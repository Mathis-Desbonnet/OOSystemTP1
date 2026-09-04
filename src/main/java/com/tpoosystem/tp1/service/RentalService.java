package com.tpoosystem.tp1.service;

import com.tpoosystem.tp1.data.Car;
import com.tpoosystem.tp1.data.Dates;

import java.util.List;

public interface RentalService {

    List<Car> getAllCars();
    Car getCarFromPlateNumber(String plateNumber) ;
    String updateCarRentFromPlateNumber(String plateNumber, boolean rent, Dates dates);
    String addCar(Car car);
}
