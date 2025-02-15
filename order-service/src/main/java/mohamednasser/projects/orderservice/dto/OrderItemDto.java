package mohamednasser.projects.orderservice.dto;

import java.math.BigDecimal;


public record OrderItemDto(
        Long id,
        String skuCode,
        BigDecimal price,
        Integer quantity) {
}
