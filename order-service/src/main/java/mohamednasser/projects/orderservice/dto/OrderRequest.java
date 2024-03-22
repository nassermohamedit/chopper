package mohamednasser.projects.orderservice.dto;

import java.util.List;

public record OrderRequest(List<OrderItemDto> orderItems) {
}
