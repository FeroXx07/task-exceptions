package level_1.exercise_1_excepcions_personalitzades;

import java.util.List;

public class Sale {
    private final List<Product> products;
    private Double totalPrice;

    public Sale(List<Product> products) {
        this.products = products;
        totalPrice = 0.0;
    }

    public void validatedCalculateTotal() throws EmptySaleException {
        if (products.isEmpty()){
            throw new EmptySaleException("Per fer una venda primer has d’afegir productes");
        }

        totalPrice = 0.0;
        totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void unValidatedCalculateTotal() {
        if (products.isEmpty()){
            throw new EmptySaleRuntimeException("Per fer una venda primer has d’afegir productes");
        }

        totalPrice = 0.0;
        totalPrice = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public double getPriceFirstProduct(){
        return products.get(0).getPrice();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
