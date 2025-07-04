import java.util.Scanner;

class Seat {
    private String seatNumber;
    private boolean isAvailable;

    public Seat(String seatNumber, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public String getSeatNumber() { return seatNumber; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}

class Passenger {
    private String name;
    private String passportNumber;
    private String email;

    public Passenger(String name, String passportNumber, String email) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
    }

    public String getName() { return name; }
    public String getPassportNumber() { return passportNumber; }
    public String getEmail() { return email; }
}

class Flight {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private String departureTime;
    private String arrivalTime;
    private double basePrice;
    private Seat[] seats;

    public Flight(String flightNumber, String departureCity, String arrivalCity, 
                 String departureTime, String arrivalTime, double basePrice, int totalSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
        this.seats = new Seat[totalSeats];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat("S" + (i + 1), true);
        }
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public double getBasePrice() { return basePrice; }
    public Seat[] getSeats() { return seats; }
}

class Booking {
    private String bookingId;
    private Flight flight;
    private Passenger passenger;
    private Seat[] selectedSeats;
    private double totalPrice;
    private boolean isConfirmed;

    public Booking(Flight flight, Passenger passenger, Seat[] selectedSeats) {
        this.bookingId = "B" + System.currentTimeMillis();
        this.flight = flight;
        this.passenger = passenger;
        this.selectedSeats = selectedSeats;
        this.totalPrice = flight.getBasePrice() * selectedSeats.length;
        this.isConfirmed = false;
    }

    public void confirmBooking() {
        this.isConfirmed = true;
        for (Seat seat : selectedSeats) {
            seat.setAvailable(false);
        }
    }

    public String getBookingConfirmation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Booking ID: ").append(bookingId).append("\n");
        sb.append("Passenger: ").append(passenger.getName()).append("\n");
        sb.append("Flight: ").append(flight.getFlightNumber()).append("\n");
        sb.append("Route: ").append(flight.getDepartureCity())
          .append(" to ").append(flight.getArrivalCity()).append("\n");
        sb.append("Departure: ").append(flight.getDepartureTime()).append("\n");
        sb.append("Seats: ");
        for (Seat seat : selectedSeats) {
            sb.append(seat.getSeatNumber()).append(" ");
        }
        sb.append("\nTotal Price: $").append(totalPrice);
        sb.append("\nStatus: ").append(isConfirmed ? "CONFIRMED" : "PENDING");
        return sb.toString();
    }

    public String getBookingId() { return bookingId; }
    public double getTotalPrice() { return totalPrice; }
    public boolean isConfirmed() { return isConfirmed; }
}

public class FlightBookingSystem {
    private Flight[] availableFlights;
    private int flightCount;

    public FlightBookingSystem(int maxFlights) {
        availableFlights = new Flight[maxFlights];
        flightCount = 0;
    }

    public void addFlight(Flight flight) {
        if (flightCount < availableFlights.length) {
            availableFlights[flightCount++] = flight;
        }
    }

    public void displayAvailableFlights() {
        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < flightCount; i++) {
            Flight flight = availableFlights[i];
            System.out.printf("%d. %s: %s to %s (%s - %s) $%.2f\n",
                    i + 1, flight.getFlightNumber(), flight.getDepartureCity(),
                    flight.getArrivalCity(), flight.getDepartureTime(),
                    flight.getArrivalTime(), flight.getBasePrice());
        }
    }

    public Flight selectFlight(int index) {
        if (index >= 0 && index < flightCount) {
            return availableFlights[index];
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightBookingSystem system = new FlightBookingSystem(10);

        // Add sample flights (now 5 total flights)
        system.addFlight(new Flight("F100", "New York", "London", "10:00", "22:00", 500.00, 5));
        system.addFlight(new Flight("F200", "Paris", "Tokyo", "08:00", "16:00", 800.00, 5));
        system.addFlight(new Flight("F300", "Dubai", "Singapore", "14:00", "22:30", 650.00, 5));
        system.addFlight(new Flight("F400", "Sydney", "Los Angeles", "18:00", "12:00", 1200.00, 5));
        system.addFlight(new Flight("F500", "Hong Kong", "Toronto", "09:00", "14:00", 950.00, 5));

        System.out.println("Welcome to Java Flight Booking System");
        system.displayAvailableFlights();

        // Flight selection
        System.out.print("\nSelect a flight (1-" + system.flightCount + "): ");
        int choice = scanner.nextInt() - 1;
        Flight flight = system.selectFlight(choice);

        if (flight == null) {
            System.out.println("Invalid selection");
            scanner.close();
            return;
        }

        // Seat selection
        System.out.println("\nAvailable Seats:");
        for (Seat seat : flight.getSeats()) {
            if (seat.isAvailable()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }

        System.out.print("\n\nEnter seat numbers (comma separated): ");
        scanner.nextLine();
        String[] seatNumbers = scanner.nextLine().split(",");
        Seat[] selectedSeats = new Seat[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            for (Seat seat : flight.getSeats()) {
                if (seat.getSeatNumber().equals(seatNumbers[i].trim())) {
                    selectedSeats[i] = seat;
                    break;
                }
            }
        }

        // Passenger details
        System.out.println("\nEnter passenger details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Passport: ");
        String passport = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Passenger passenger = new Passenger(name, passport, email);
        Booking booking = new Booking(flight, passenger, selectedSeats);

        // Confirmation
        System.out.println("\nBooking Summary:");
        System.out.println(booking.getBookingConfirmation());
        
        System.out.print("\nConfirm booking? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            booking.confirmBooking();
            System.out.println("\nBooking confirmed!");
            System.out.println(booking.getBookingConfirmation());
        } else {
            System.out.println("Booking cancelled");
        }

        scanner.close();
    }
}