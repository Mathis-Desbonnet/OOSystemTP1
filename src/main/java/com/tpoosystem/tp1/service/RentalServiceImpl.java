package com.tpoosystem.tp1.service;

import com.tpoosystem.tp1.data.*;
import com.tpoosystem.tp1.exception.CarAlreadyRentedException;
import com.tpoosystem.tp1.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RentingRepository rentingRepository;

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car getCarFromPlateNumber(String plateNumber) {
        for (Car car : carRepository.findAll()) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        throw new CarNotFoundException(plateNumber);
    }

    public String updateCarRentFromPlateNumber(String plateNumber, boolean rent, Dates dates) {
        if (rent) {
            Car car = getCarFromPlateNumber(plateNumber);
            if (car.getCurrentRenting() != null) {
                throw new CarAlreadyRentedException(plateNumber, car.getCurrentRenting().getEndDate().toString());
            } else {
                if (dates == null) {
                    Renting carNewRent = new Renting(LocalDate.now(), LocalDate.now().plusMonths(1));
                    car.addRenting(carNewRent);
                    rentingRepository.save(carNewRent);
                    return "Car rented from " + LocalDate.now() + " to " + LocalDate.now().plusMonths(1);
                } else {
                    Renting carNewRent = new Renting(dates.getStartDate(), dates.getEndDate());
                    car.addRenting(carNewRent);
                    rentingRepository.save(carNewRent);
                    return "Car rented from " + dates.getStartDate() + " to " + dates.getEndDate();
                }
            }
        } else {
            Car car = getCarFromPlateNumber(plateNumber);
            if (car.stopRenting()) {
                return "Car renting is cancel !";
            } else {
                return "Car not rented for the moment.";
            }
        }
    }

    public String addCar(Car car) {
        carRepository.save(car);
        return "Correctly added a car";
    }

}
