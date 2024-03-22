package mohamednasser.projects.orderservice.service;


import lombok.RequiredArgsConstructor;
import mohamednasser.projects.orderservice.dto.InventoryResponse;
import mohamednasser.projects.orderservice.dto.OrderItemDto;
import mohamednasser.projects.orderservice.dto.OrderRequest;
import mohamednasser.projects.orderservice.model.Order;
import mohamednasser.projects.orderservice.repository.OrderRepository;
import mohamednasser.projects.orderservice.utility.EntityDtoConverters;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    public Order placeOrder(OrderRequest orderRequest) throws Exception {
        List<String> skuCodes = orderRequest.orderItems().stream().map(OrderItemDto::skuCode).toList();
        InventoryResponse[] inventories = getInventories(skuCodes);
        boolean result = Arrays.stream(inventories).allMatch(inventory -> inventory.quantity > 0);
        if (!result) throw new Exception("Insufficient inventory. Try again later.");
        Order order = EntityDtoConverters.createOrderFromOrderRequest(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());
        return this.orderRepository.save(order);
    }

    private InventoryResponse[] getInventories(List<String> skuCodes) {
        return this.webClientBuilder.build()
                .get()
                .uri(
                        "http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
    }
}
