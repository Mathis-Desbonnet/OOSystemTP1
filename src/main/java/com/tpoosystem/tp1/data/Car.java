package com.tpoosystem.tp1.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {

    private String plateNumber;
    private String brand;
    private float price;

    public Car() {
        plateNumber = "";
        brand = "";
        price = 0;
    }

    public Car(String plateNumber, String brand, float price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    @Id
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
