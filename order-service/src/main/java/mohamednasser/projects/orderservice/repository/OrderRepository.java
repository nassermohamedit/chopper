package mohamednasser.projects.orderservice.repository;

import mohamednasser.projects.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
