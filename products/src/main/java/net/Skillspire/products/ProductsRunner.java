package net.Skillspire.products;

import org.springframework.stereotype.Component;

@Component
public class ProductsRunner implements org.springframework.boot.CommandLineRunner {

    private final ProductRepository repo;

    public ProductsRunner(ProductRepository repo) {
        this.repo = repo;
    }


    @Override
    public void run(String... args) {
        //Adding products
        repo.save(new Product("Takis", "Chips", 5.0, 10));
        repo.save(new Product("Cheetos", "Chips", 4.50, 15));
        repo.save(new Product("Ruffles", "Chips", 4.75, 0));
        repo.save(new Product("Doritoes", "Chips", 3.99, 20));
        repo.save(new Product("Coca-Cola", "Soda", 2.99, 30));
        repo.save(new Product("Pepsi", "Soda", 2.75, 35));
        repo.save(new Product("Crush", "Soda", 2.50, 40));
        repo.save(new Product("Cookies", "Deserts", 4.99, 24));
        repo.save(new Product("Cheesecake","Deserts", 8.99, 0));
        repo.save(new Product("Pumpkin Pie", "Deserts", 9.99, 14));

        //Running methods
        System.out.println("Soda products: " + repo.findByCategory("Soda"));
        System.out.println("Products less than 4 dollars: " + repo.findByPriceLessThan(4));
        System.out.println("We no longer have the following items in stock: " + repo.findByStockQuantity());

        //Running custom Query
        for (Object[] row : repo.priceAverageByCategory()) {
            System.out.println("Average price of " + row[0] + ": " + row[1]);
        }





    }
}
