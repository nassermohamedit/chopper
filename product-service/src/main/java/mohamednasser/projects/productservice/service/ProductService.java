package mohamednasser.projects.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import mohamednasser.projects.productservice.dto.ProductRequest;
import mohamednasser.projects.productservice.dto.ProductResponse;
import mohamednasser.projects.productservice.model.Product;
import mohamednasser.projects.productservice.repository.ProductRepository;
import mohamednasser.projects.productservice.utility.EntityDtoConverters;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository repository;

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = EntityDtoConverters.productRequestToProduct(productRequest);
        return EntityDtoConverters.productToProductResponse(this.repository.save(product));
    }

    public List<ProductResponse> getAllProducts() {

        return this.repository.findAll().stream()
                .map(EntityDtoConverters::productToProductResponse)
                .toList();
    }
}
