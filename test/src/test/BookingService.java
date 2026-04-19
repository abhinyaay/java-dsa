package test;

import java.util.*;
import java.util.stream.Collectors;

interface BookingService {

    void addBooking(Booking b);

    void removeBooking(int id) throws BookingNotFoundException;

    void listBookings();

    default void displayBookingSummary(List<Booking> bookings) {
        System.out.println("\n--- Booking Summary ---");
        System.out.println("Total Bookings: " + bookings.size());

        Map<ServiceType, Long> countMap = bookings.stream()
                .collect(Collectors.groupingBy(Booking::getServiceType, Collectors.counting()));

        for (ServiceType type : ServiceType.values()) {
            System.out.println(type + ": " + countMap.getOrDefault(type, 0L));
        }
    }
}