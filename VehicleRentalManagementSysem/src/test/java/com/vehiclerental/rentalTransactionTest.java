import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class rentalTransactionTest {

    @Test
    public void testRentalTransactionConstructor() {
        Car car = new Car("C123", "Toyota Camry", 50.0, true);
        RentalTransaction transaction = new RentalTransaction(car, 5);

        assertNotNull(transaction);
        assertEquals(300.0, transaction.getTotalCost());  // Base rate 50 * 5 days
    }

    @Test
    public void testTotalCostCalculation() {
        Truck truck = new Truck("T123", "Ford F-150", 100.0, 1200.0);
        RentalTransaction transaction = new RentalTransaction(truck, 6);
        assertEquals(720.0, transaction.getTotalCost());  // Base rate 100 * 6 + 120 * 6
    }
}
