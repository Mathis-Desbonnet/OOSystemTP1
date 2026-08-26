package com.tpoosystem.tp1.service;

import com.tpoosystem.tp1.data.Car;
import com.tpoosystem.tp1.data.Dates;
import com.tpoosystem.tp1.exception.CannotRentCarException;
import com.tpoosystem.tp1.exception.CarAlreadyRentedException;
import com.tpoosystem.tp1.exception.CarNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{
    private List<Car> allCars;
    private List<Car> carsRented;
    private HashMap<Car, Dates> carsRentedDates;

    public RentalServiceImpl() {
        allCars = new ArrayList<>();
        allCars.add(new Car("AABBAA", "Ferrari", 100));
        allCars.add(new Car("AABBCC", "Peugeot", 10));
        carsRented = new ArrayList<>();
        carsRentedDates = new HashMap<>();
    }

    public List<Car> getAllCars() {
        return allCars;
    }

    public Car getCarFromPlateNumber(String plateNumber) {
        for (Car car : allCars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        throw new CarNotFoundException(plateNumber);
    }

    public String getCarFromPlateNumber(String plateNumber, boolean rent, Dates dates) {
        if (rent) {
            for (Car car : allCars) {
                if (car.getPlateNumber().equals(plateNumber)) {
                    if (carsRented.contains(car)) {
                        throw new CarAlreadyRentedException(plateNumber, carsRentedDates.get(car).getEndDate().toString());
                    } else {
                        carsRented.add(car);
                        if (dates == null) {
                            carsRentedDates.put(car, new Dates());
                            return "Car rented from " + LocalDate.now() + " to " + LocalDate.now().plusMonths(1);
                        } else {
                            carsRentedDates.put(car, dates);
                            return "Car rented from " + dates.getStartDate() + " to " + dates.getEndDate();
                        }
                    }
                } else {
                    throw new CarNotFoundException(plateNumber);
                }
            }
        } else {
            for (Car car : allCars) {
                if (car.getPlateNumber().equals(plateNumber)) {
                    if (carsRented.contains(car)) {
                        carsRented.remove(car);
                        carsRentedDates.remove(car);
                        return "Car renting is cancel !";
                    } else {
                        return "Car not rented for the moment.";
                    }
                }
            }
        }
        throw new CannotRentCarException();
    }

    public String addCar(Car car) {
        allCars.add(car);
        return "Correctly added a car";
    }

}
