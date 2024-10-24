package org.forkstore;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(method = RequestMethod.GET, value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    String searchByCategory(@RequestParam(name = "category") String category) {
        return "";
    }
}
