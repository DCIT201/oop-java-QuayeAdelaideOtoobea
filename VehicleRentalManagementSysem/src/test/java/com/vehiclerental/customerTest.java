import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class customerTest {

    @Test
    public void testCustomerConstructor() {
        Customer customer = new Customer("C001", "John Doe");
        assertNotNull(customer);
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testAddRental() {
        Customer customer = new Customer("C001", "John Doe");
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        customer.addRental(car, 5);
        assertEquals(1, customer.getRentalHistory().size());
    }
}
