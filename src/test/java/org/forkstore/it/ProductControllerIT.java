package org.forkstore.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldSearchByCategory_Ok() throws Exception {
        var queryParamName = "category";
        var queryParamValue = "acategory";

        var response = mockMvc
            .perform(get("/product").queryParam(queryParamName, queryParamValue))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();

        assertThat(response.getRequest().getParameter(queryParamName)).isEqualTo(queryParamValue);
    }
}
