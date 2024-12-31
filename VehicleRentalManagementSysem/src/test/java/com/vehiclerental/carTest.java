import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class carTest {

    @Test
    public void testRent() {
        // Create a customer and a car
        Customer customer = new Customer("C001", "John Doe");
        Car car = new Car("C123", "Toyota Camry", 50.0, true);

        // Rent the car
        car.rent(customer, 3);

        // Assert that the car's availability is now false (it has been rented)
        assertFalse(car.isAvailableForRental());
        // Assert that the customer has the car in their rental history
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(car, customer.getRentalHistory().get(0));  // The car should be in the rental history
    }

    @Test
    public void testReturnVehicle() {
        Customer customer = new Customer("C001", "John Doe");
        Car car = new Car("C123", "Toyota Camry", 50.0, true);

        car.rent(customer, 3);  // Rent the car
        car.returnVehicle();  // Return the car

        // Assert that the car is now available for rental
        assertTrue(car.isAvailableForRental());
        // Assert that the customer no longer has the car in their rental history
        assertEquals(0, customer.getRentalHistory().size());
    }
}
