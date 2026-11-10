package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.OrderProduct;
import fr.simplon.domedespuys.Repository.OrderProductRepository;
import fr.simplon.domedespuys.Views.OrderProductView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    private OrderProductRepository orderProductRepository;

    public OrderProductController(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @GetMapping
    @JsonView(OrderProductView.OrderProductListView.class)
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(OrderProductView.OrderProductDetailView.class)
    public Optional<OrderProduct> getOrderProductById(@PathVariable Long id) {
        return orderProductRepository.findById(id);
    }
}