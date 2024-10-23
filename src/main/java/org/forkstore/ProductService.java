package org.forkstore;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> searchByCategory(String category) {
        return repository.findByCategory(category);
    }
}
