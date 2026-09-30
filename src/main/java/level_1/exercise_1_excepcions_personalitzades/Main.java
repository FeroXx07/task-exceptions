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

    void main(String[] args) {
        try {
            sale.calculateTotal();
        } catch (EmptySaleException e) {
            LOGGER.error("failed to calculate total price", e);
        }
    }

}
