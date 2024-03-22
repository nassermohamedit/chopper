package mohamednasser.projects.productservice.testutils;

import mohamednasser.projects.productservice.dto.ProductRequest;
import mohamednasser.projects.productservice.dto.ProductResponse;
import mohamednasser.projects.productservice.model.Product;

import java.math.BigDecimal;

public class TestUtils {

    /*
    * TODO - create ProductResponse ProductRequest for each Product object
    */

    public static final ProductRequest PRODUCT_REQUEST_OBJECT;
    public static final Product PRODUCT_WITHOUT_ID_OBJECT;
    public static final Product PRODUCT_OBJECT;
    public static final ProductResponse PRODUCT_RESPONSE_OBJECT;

    static {
        PRODUCT_OBJECT = new Product("1", "atay", "tasty tea", BigDecimal.valueOf(11));

        PRODUCT_RESPONSE_OBJECT = new ProductResponse(
                PRODUCT_OBJECT.getId(),
                PRODUCT_OBJECT.getName(),
                PRODUCT_OBJECT.getDescription(),
                PRODUCT_OBJECT.getPrice()
        );

        PRODUCT_REQUEST_OBJECT = new ProductRequest(
                PRODUCT_OBJECT.getName(),
                PRODUCT_OBJECT.getDescription(),
                PRODUCT_OBJECT.getPrice()
        );

        PRODUCT_WITHOUT_ID_OBJECT = new Product(
                null,
                PRODUCT_OBJECT.getName(),
                PRODUCT_OBJECT.getDescription(),
                PRODUCT_OBJECT.getPrice()
        );
    }

}
