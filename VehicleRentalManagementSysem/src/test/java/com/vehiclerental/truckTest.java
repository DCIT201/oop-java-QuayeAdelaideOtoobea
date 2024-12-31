import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class truckTest {

    @Test
    public void testRent() {
        Customer customer = new Customer("T001", "Bob Johnson");
        Truck truck = new Truck("T123", "Ford F-150", 100.0, 1500.0);

        // Rent the truck
        truck.rent(customer, 6);

        // Assert that the truck's availability is now false (it has been rented)
        assertFalse(truck.isAvailableForRental());
        // Assert that the customer has the truck in their rental history
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(truck, customer.getRentalHistory().get(0));  // The truck should be in the rental history
    }

    @Test
    public void testReturnVehicle() {
        Customer customer = new Customer("T001", "Bob Johnson");
        Truck truck = new Truck("T123", "Ford F-150", 100.0, 1500.0);

        truck.rent(customer, 6);  // Rent the truck
        truck.returnVehicle();  // Return the truck

        // Assert that the truck is now available for rental
        assertTrue(truck.isAvailableForRental());
        // Assert that the customer no longer has the truck in their rental history
        assertEquals(0, customer.getRentalHistory().size());
    }
}
