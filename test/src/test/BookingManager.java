package test;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String msg) {
        super(msg);
    }
}

class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String msg) {
        super(msg);
    }
}

public class BookingManager implements BookingService {

    private List<Booking> bookings = new ArrayList<>();
    private final String FILE_NAME = "bookings.dat";

    @Override
    public void addBooking(Booking b) {
        bookings.add(b);
        System.out.println("Booking added successfully!");
    }

    @Override
    public void removeBooking(int id) throws BookingNotFoundException {
        Booking found = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == id) {
                found = b;
                break;
            }
        }

        if (found == null) {
            throw new BookingNotFoundException("Booking ID not found!");
        }

        bookings.remove(found);
        System.out.println("Booking removed successfully!");
    }

    @Override
    public void listBookings() {
        Predicate<Booking> sortByDate = b -> true;

        bookings.stream()
                .filter(sortByDate)
                .sorted(Comparator.comparing(Booking::getServiceDate))
                .forEach(System.out::println);
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(bookings);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            bookings = (List<Booking>) ois.readObject();
            System.out.println("Data loaded from file.");
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingManager manager = new BookingManager();
        manager.loadFromFile();

        while (true) {
            System.out.println("\n1. Add Booking");
            System.out.println("2. Remove Booking");
            System.out.println("3. Display All Bookings");
            System.out.println("4. Display Summary");
            System.out.println("5. Save & Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Vehicle Number: ");
                        String vehicle = sc.nextLine();

                        if (name.isEmpty() || vehicle.isEmpty()) {
                            throw new InvalidBookingException("Invalid input!");
                        }

                        System.out.println("Select Service (REGULAR/REPAIR/CLEANING): ");
                        ServiceType type = ServiceType.valueOf(sc.nextLine().toUpperCase());

                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(sc.nextLine());

                        Booking b = new ServiceBooking(name, vehicle, type, date);
                        manager.addBooking(b);
                        break;

                    case 2:
                        System.out.print("Enter Booking ID: ");
                        int id = sc.nextInt();
                        manager.removeBooking(id);
                        break;

                    case 3:
                        manager.listBookings();
                        break;

                    case 4:
                        manager.displayBookingSummary(manager.bookings);
                        break;

                    case 5:
                        manager.saveToFile();
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InvalidBookingException | BookingNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input format!");
            }
        }
    }
}