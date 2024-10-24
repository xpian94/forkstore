package org.forkstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET, value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product> searchByCategory(@RequestParam(name = "category") String category) {
        return service.searchByCategory(category);
    }
}
