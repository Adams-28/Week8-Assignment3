package net.Skillspire.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product>findByCategory(String category);
    List<Product>findByPriceLessThan(double price);

    @Query("SELECT p FROM Product p WHERE p.stockQuantity = 0")
    List<Product>findByStockQuantity();

    @Query("SELECT p.category, AVG(p.price) FROM Product p GROUP BY p.category")
    List<Object[]>priceAverageByCategory();



}
