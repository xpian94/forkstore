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
    void shouldFindByCategory() {
        var one = Product.builder()
            .category("category")
            .build();

        var two = Product.builder()
            .category("category")
            .build();

        repository.saveAll(List.of(one, two));

        var products = repository.findByCategory("category");

        one = products.get(0);
        two = products.get(1);

        assertThat(one.getId()).isEqualTo(1L);
        assertThat(two.getId()).isEqualTo(2L);
    }
}
