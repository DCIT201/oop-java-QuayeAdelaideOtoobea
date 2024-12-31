import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class rentalAgencyTest {

    @Test
    public void testAddVehicle() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        agency.addVehicle(car);
        assertEquals(1, agency.getVehicleFleet().size());
    }

    @Test
    public void testRentVehicle() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        Customer customer = new Customer("C001", "John Doe");

        agency.addVehicle(car);
        agency.rentVehicle(customer, car, 5);

        assertEquals(1, customer.getRentalHistory().size());
        assertFalse(car.isAvailableForRental());
    }

    @Test
    public void testRentVehicleWhenUnavailable() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        Customer customer = new Customer("C001", "John Doe");

        agency.addVehicle(car);
        car.setAvailability(false); // Mark as unavailable

        agency.rentVehicle(customer, car, 5);
        assertEquals(0, customer.getRentalHistory().size());
    }
}
