package mohamednasser.projects.productservice.utility;

import mohamednasser.projects.productservice.dto.ProductRequest;
import mohamednasser.projects.productservice.dto.ProductResponse;
import mohamednasser.projects.productservice.model.Product;

public class EntityDtoConverters {

    public static ProductResponse productToProductResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice()
        );
    }

    public static Product productRequestToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
    }
}
