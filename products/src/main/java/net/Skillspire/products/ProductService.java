package net.Skillspire.products;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product p) {
        p.setId(null);
        return productRepository.save(p);
    }

    public Product updateProduct(Long id, Product p) {
        Product existing = productRepository.findById(id).orElse(null);

        if(existing == null) {
            return null;
        }

        existing.setName((p.getName()));
        existing.setCategory(p.getCategory());
        existing.setPrice(p.getPrice());
        existing.setStockQuantity(p.getStockQuantity());

        return productRepository.save(existing);
    }


    public boolean deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {
            return false;
        }

        productRepository.deleteById(id);

        return true;
    }




}
