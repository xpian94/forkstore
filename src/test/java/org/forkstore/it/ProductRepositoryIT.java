package org.forkstore.it;

import org.forkstore.Product;
import org.forkstore.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryIT {
    @Autowired
    private ProductRepository repository;

    @Test
    void nothing() {
        Product one = Product.builder()
            .category("category")
            .build();

        Product two = Product.builder()
            .category("category")
            .build();

        repository.saveAll(List.of(one, two));

        var products = repository.findByCategory("category");

        Product first = products.get(0);
        Product second = products.get(1);

        assertThat(first.getId()).isEqualTo(1L);
        assertThat(second.getId()).isEqualTo(2L);
    }
}
