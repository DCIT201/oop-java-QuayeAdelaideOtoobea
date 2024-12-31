import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class vehicleTest {

    @Test
    public void testSetAndGetBaseRentalRate() {
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        car.setBaseRentalRate(60.0);
        assertEquals(60.0, car.getBaseRentalRate());
    }

    @Test
    public void testSetBaseRentalRateValidation() {
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        assertThrows(IllegalArgumentException.class, () -> car.setBaseRentalRate(-10.0));
    }

    @Test
    public void testIsAvailableForRental() {
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        assertTrue(car.isAvailableForRental());
        car.setAvailability(false);
        assertFalse(car.isAvailableForRental());
    }
}
