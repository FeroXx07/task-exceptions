package level_1.exercise_1_excepcions_personalitzades;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    Product apples = new Product("apple", 1.0);
    Product iPhone = new Product("iPhone", 600.0);
    Product[] cart = new Product[] {apples, iPhone};
    Sale sale = new Sale(List.of(cart));
    Sale emptySale = new Sale(List.of());

    void main(String[] args) {
        // First test -> EmptySaleException
        try {
            sale.validatedCalculateTotal();
            emptySale.validatedCalculateTotal();
        } catch (EmptySaleException exceptionA) {
            LOGGER.error("Empty sale error: ", exceptionA);
        }

        // Second test -> ArrayIndexOutOfBoundsException
        try {
            emptySale.getPriceFirstProduct();
        } catch (RuntimeException exceptionB) {
            LOGGER.error("Unknown runtime exception: ", exceptionB);
        }

        // Third test -> EmptySaleRuntimeException
        try {
            emptySale.unValidatedCalculateTotal();
        } catch (RuntimeException exceptionB) {
            LOGGER.error("Unknown runtime exception: ", exceptionB);
        }
    }
}
