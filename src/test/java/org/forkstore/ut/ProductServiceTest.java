package org.forkstore.ut;

import org.forkstore.ProductRepository;
import org.forkstore.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private void stubbingFindByCategory(String category, List<Object> products) {
        when(repository.findByCategory(category)).thenReturn(products);
    }

    private void searchByCategoryAndAssert(String category, int expectedSize) {
        var found = service.searchByCategory(category);

        verify(repository).findByCategory(category);

        assertThat(found.size()).isEqualTo(expectedSize);
    }

    @Test
    void shouldSearchByCategory() {
        String category = "category";
        String other = "other";

        List<Object> productsFromCategory = List.of(new Object());
        List<Object> productsFromOther = List.of(new Object(), new Object());

        stubbingFindByCategory(category, productsFromCategory);
        stubbingFindByCategory(other, productsFromOther);

        searchByCategoryAndAssert("category", 1);
        searchByCategoryAndAssert("other", 2);
    }
}
