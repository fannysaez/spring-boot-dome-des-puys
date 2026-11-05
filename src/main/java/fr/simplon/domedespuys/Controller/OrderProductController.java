package fr.simplon.domedespuys.Controller;

import fr.simplon.domedespuys.DTO.OrderProductDTO;
import fr.simplon.domedespuys.Service.OrderProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    private OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public List<OrderProductDTO> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }

    @GetMapping("/{id}")
    public OrderProductDTO getOrderProductById(@PathVariable Long id) {
        return orderProductService.getOrderProductById(id);
    }
}