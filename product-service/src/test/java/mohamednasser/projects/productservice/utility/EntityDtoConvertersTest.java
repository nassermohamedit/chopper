package mohamednasser.projects.productservice.utility;

import mohamednasser.projects.productservice.testutils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EntityDtoConvertersTest {

    @Test
    void productToProductResponse() {
        Assertions.assertEquals(
                EntityDtoConverters.productToProductResponse(TestUtils.PRODUCT_OBJECT),
                TestUtils.PRODUCT_RESPONSE_OBJECT
        );
    }

    @Test
    void productRequestToProduct() {
        Assertions.assertEquals(
                EntityDtoConverters.productRequestToProduct(TestUtils.PRODUCT_REQUEST_OBJECT),
                TestUtils.PRODUCT_WITHOUT_ID_OBJECT
        );
    }
}