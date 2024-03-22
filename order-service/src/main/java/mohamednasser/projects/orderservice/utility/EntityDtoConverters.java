package mohamednasser.projects.orderservice.utility;

import mohamednasser.projects.orderservice.dto.OrderItemDto;
import mohamednasser.projects.orderservice.dto.OrderRequest;
import mohamednasser.projects.orderservice.model.Order;
import mohamednasser.projects.orderservice.model.OrderItem;

public class EntityDtoConverters {

    public static OrderItem orderItemDtoToEntity(OrderItemDto dto) {

        return OrderItem.builder()
                .id(dto.id())
                .price(dto.price())
                .skuCode(dto.skuCode())
                .quantity(dto.quantity())
                .build();
    }
    public static Order createOrderFromOrderRequest(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderItems(orderRequest.orderItems()
                .stream()
                .map(EntityDtoConverters::orderItemDtoToEntity)
                .toList()
        );
        return order;
    }
}
