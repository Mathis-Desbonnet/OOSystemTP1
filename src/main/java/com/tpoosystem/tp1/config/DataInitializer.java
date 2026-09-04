package com.tpoosystem.tp1.config;

import com.tpoosystem.tp1.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer {

    @Autowired
    private CarRepository carRepo;

    @Autowired
    private RentingRepository rentingRepo;

    @Autowired
    private BrandRepository brandRepo;

    @EventListener(ApplicationReadyEvent.class)
    private void InitData() {

        Brand BMW = new Brand("BWM");
        brandRepo.save(BMW);

        Car car1 = new Car();
        car1.setPlateNumber("123AA456");
        car1.setBrand(BMW);
        car1.setPrice(75500);

        Renting car1Rent = new Renting(LocalDate.now(), LocalDate.now().plusMonths(1));

        car1.addRenting(car1Rent);
        carRepo.save(car1);
        rentingRepo.save(car1Rent);

        Car car2 = new Car();
        car2.setPlateNumber("789BB123");
        car2.setBrand(BMW);
        car2.setPrice(10000);

        carRepo.save(car2);
    }
}
