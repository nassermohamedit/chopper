package mohamednasser.projects.productservice.service;

import mohamednasser.projects.productservice.dto.ProductRequest;
import mohamednasser.projects.productservice.dto.ProductResponse;
import mohamednasser.projects.productservice.model.Product;
import mohamednasser.projects.productservice.repository.ProductRepository;

import mohamednasser.projects.productservice.testutils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static mohamednasser.projects.productservice.testutils.TestUtils.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setup() {
        this.productService = new ProductService(this.productRepository);
    }

    @Test
    public void createProductShouldReturnProductResponseWithIdSet() {
        Mockito.when(this.productRepository.save(PRODUCT_WITHOUT_ID_OBJECT)).thenReturn(PRODUCT_OBJECT);
        ProductResponse productResponse = productService.createProduct(PRODUCT_REQUEST_OBJECT);
        ArgumentCaptor<Product> argCaptor = ArgumentCaptor.forClass(Product.class);
        Mockito.verify(this.productRepository).save(argCaptor.capture());
        Product product = argCaptor.getValue();
        Assertions.assertEquals(product, PRODUCT_WITHOUT_ID_OBJECT);
        Assertions.assertEquals(productResponse, PRODUCT_RESPONSE_OBJECT);
    }

    @Test
    public void getAllProductTest() {
        Mockito.when(this.productRepository.findAll()).thenReturn(List.of(PRODUCT_OBJECT));
        List<ProductResponse> productResponses = this.productService.getAllProducts();
        Mockito.verify(this.productRepository).findAll();
        Assertions.assertEquals(productResponses.size(), 1);
        Assertions.assertEquals(productResponses.get(0), TestUtils.PRODUCT_RESPONSE_OBJECT);
    }
}