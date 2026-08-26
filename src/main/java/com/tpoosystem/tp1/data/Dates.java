package com.tpoosystem.tp1.data;

import java.time.LocalDate;

public class Dates {
    private LocalDate startDate;
    private LocalDate endDate;

    public Dates() {
        startDate = LocalDate.now();
        endDate = LocalDate.now();
        endDate = endDate.plusMonths(1);
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
}
