package mohamednasser.projects.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mohamednasser.projects.productservice.service.ProductService;
import static mohamednasser.projects.productservice.testutils.TestUtils.PRODUCT_RESPONSE_OBJECT;
import static mohamednasser.projects.productservice.testutils.TestUtils.PRODUCT_REQUEST_OBJECT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;


@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @MockBean
    private ProductService productService;
    private ProductController productController;
    @Autowired
    private MockMvc mvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
    }
    @Test
    void createProduct() throws Exception {
        Mockito.when(this.productService.createProduct(PRODUCT_REQUEST_OBJECT))
                .thenReturn(PRODUCT_RESPONSE_OBJECT);
        this.mvc.perform(MockMvcRequestBuilders
                        .post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(PRODUCT_REQUEST_OBJECT))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(PRODUCT_RESPONSE_OBJECT.id()))
                .andExpect(jsonPath("$.name").value(PRODUCT_RESPONSE_OBJECT.name()))
                .andExpect(jsonPath("$.description").value(PRODUCT_RESPONSE_OBJECT.description()))
                .andExpect(jsonPath("$.price").value(PRODUCT_RESPONSE_OBJECT.price()))
                .andReturn();
    }

    @Test
    void getAllProducts() throws Exception {

        Mockito.when(this.productService.getAllProducts())
                .thenReturn(List.of(PRODUCT_RESPONSE_OBJECT));

        this.mvc.perform(MockMvcRequestBuilders
                        .get("/api/product/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(PRODUCT_RESPONSE_OBJECT.id()))
                .andExpect(jsonPath("$[0].name").value(PRODUCT_RESPONSE_OBJECT.name()))
                .andExpect(jsonPath("$[0].price").value(PRODUCT_RESPONSE_OBJECT.price()))
                .andExpect(jsonPath("$[0].description").value(PRODUCT_RESPONSE_OBJECT.description()))
                .andReturn();

    }
}