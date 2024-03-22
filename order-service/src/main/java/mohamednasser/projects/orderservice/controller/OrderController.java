package mohamednasser.projects.orderservice.controller;


import lombok.RequiredArgsConstructor;
import mohamednasser.projects.orderservice.dto.OrderRequest;
import mohamednasser.projects.orderservice.model.Order;
import mohamednasser.projects.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) throws Exception{

        try {
            this.orderService.placeOrder(orderRequest);
        } catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Order placed successfully");
    }

    @GetMapping("/up")
    public String up() {
        return "order-service is up";
    }

}
