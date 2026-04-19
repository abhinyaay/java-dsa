package test;

import java.io.Serializable;
import java.time.LocalDate;

enum ServiceType {
    REGULAR, REPAIR, CLEANING
}

public abstract class Booking implements Serializable {
    private static int counter = 1;

    protected int bookingId;
    protected String customerName;
    protected String vehicleNumber;
    protected ServiceType serviceType;
    protected LocalDate serviceDate;

    public Booking(String customerName, String vehicleNumber, ServiceType serviceType, LocalDate serviceDate) {
        this.bookingId = counter++;
        this.customerName = customerName;
        this.vehicleNumber = vehicleNumber;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public abstract double calculateServiceCost();

    @Override
    public String toString() {
        return "ID: " + bookingId +
                ", Name: " + customerName +
                ", Vehicle: " + vehicleNumber +
                ", Type: " + serviceType +
                ", Date: " + serviceDate +
                ", Cost: " + calculateServiceCost();
    }
}