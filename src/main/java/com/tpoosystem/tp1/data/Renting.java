package com.tpoosystem.tp1.data;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Renting {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long ID;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Car car;

    public Renting() {}

    public Renting(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
