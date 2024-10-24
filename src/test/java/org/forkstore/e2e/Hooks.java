package org.forkstore.e2e;

import io.cucumber.java.After;
import org.forkstore.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    // Cucumber supported hooks
    // @Before     => public void init()
    // @After      => public void cleanUp()
    // @BeforeStep => public void beforeStep()
    // @AfterStep  => public void afterStep()

    @Autowired
    private ProductRepository productRepository;

    @After
    public void cleanUp() {
        productRepository.deleteAll();
    }
}