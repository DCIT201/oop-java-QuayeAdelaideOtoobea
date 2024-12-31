import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class motorcycleTest {

    @Test
    public void testRent() {
        Customer customer = new Customer("M001", "Alice Smith");
        Motorcycle motorcycle = new Motorcycle("M123", "Yamaha R1", 30.0, false);

        // Rent the motorcycle
        motorcycle.rent(customer, 5);

        // Assert that the motorcycle's availability is now false (it has been rented)
        assertFalse(motorcycle.isAvailableForRental());
        // Assert that the customer has the motorcycle in their rental history
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(motorcycle, customer.getRentalHistory().get(0));  // The motorcycle should be in the rental history
    }

    @Test
    public void testReturnVehicle() {
        Customer customer = new Customer("M001", "Alice Smith");
        Motorcycle motorcycle = new Motorcycle("M123", "Yamaha R1", 30.0, false);

        motorcycle.rent(customer, 5);  // Rent the motorcycle
        motorcycle.returnVehicle();  // Return the motorcycle

        // Assert that the motorcycle is now available for rental
        assertTrue(motorcycle.isAvailableForRental());
        // Assert that the customer no longer has the motorcycle in their rental history
        assertEquals(0, customer.getRentalHistory().size());
    }
}
