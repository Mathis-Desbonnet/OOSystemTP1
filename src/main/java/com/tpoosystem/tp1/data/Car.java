package com.tpoosystem.tp1.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long ID;

    private String plateNumber;
    private float price;

    @ManyToOne
    private Brand brand;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    @JsonIgnore
    private Collection<Renting> rentings = new ArrayList<>();

    public Collection<Renting> getRentings() {
        return rentings;
    }

    public void setRentings(List<Renting> rentings) {
        this.rentings = rentings;
    }

    public Car() {
    }

    public Car(String plateNumber, Brand brand, float price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean addRenting(Renting renting) {
        if (rentings == null) {
            rentings = new ArrayList<>();
        }
        rentings.add(renting);
        renting.setCar(this);
        return true;
    }

    public boolean stopRenting() {
        if (getCurrentRenting() == null) return false;

        getCurrentRenting().setEndDate(LocalDate.now());
        return true;
    }

    @JsonIgnore
    public Renting getCurrentRenting() {
        for (Renting r : rentings) {
            System.out.println(r);
            System.out.println(r.getStartDate());
            System.out.println(r.getEndDate());
            if (r.getEndDate().isAfter(LocalDate.now())) {
                return r;
            }
        }
        return null;
    }
}
