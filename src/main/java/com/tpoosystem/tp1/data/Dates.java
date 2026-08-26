package com.tpoosystem.tp1.data;

import java.time.LocalDate;

public class Dates {
    private LocalDate startDate;
    private LocalDate endDate;

    public Dates() {
    }

    public Dates(String startDate, String endDate) {
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }

}
