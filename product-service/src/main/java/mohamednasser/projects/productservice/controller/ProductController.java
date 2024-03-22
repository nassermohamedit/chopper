package mohamednasser.projects.productservice.controller;

import lombok.RequiredArgsConstructor;

import mohamednasser.projects.productservice.dto.ProductRequest;
import mohamednasser.projects.productservice.dto.ProductResponse;
import mohamednasser.projects.productservice.service.ProductService;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = this.productService.createProduct(productRequest);
        System.out.println(productResponse.toString());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(productResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        List<ProductResponse> products = this.productService.getAllProducts();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(products);
    }
}
