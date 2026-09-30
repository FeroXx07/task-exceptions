package level_1.exercise_1_excepcions_personalitzades;

import java.util.List;

public class Sale {
    private final List<Product> products;
    private Double totalPrice;

    public Sale(List<Product> products) {
        this.products = products;
        totalPrice = 0.0;
    }

    public void calculateTotal() throws EmptySaleException {
        if (products.isEmpty()){
            throw new EmptySaleException("Per fer una venda primer has d’afegir productes");
        }

        totalPrice = 0.0;
        totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
