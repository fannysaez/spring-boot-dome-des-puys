package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.DTO.OrderProductDTO;
import fr.simplon.domedespuys.Entity.OrderProduct;
import fr.simplon.domedespuys.Repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public List<OrderProductDTO> getAllOrderProducts() {
        List<OrderProduct> orderProducts = orderProductRepository.findAll();
        List<OrderProductDTO> orderProductDTOs = new java.util.ArrayList<>();

        for (OrderProduct orderProduct : orderProducts) {
            orderProductDTOs.add(convertToDTO(orderProduct));
        }

        return orderProductDTOs;
    }

    public OrderProductDTO getOrderProductById(Long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ligne de commande introuvable avec l'id " + id));
        return convertToDTO(orderProduct);
    }

    private OrderProductDTO convertToDTO(OrderProduct orderProduct) {
        OrderProductDTO dto = new OrderProductDTO();
        dto.setId(orderProduct.getId());
        dto.setQuantity(orderProduct.getQuantity());
        dto.setPrice(orderProduct.getPrice());
        dto.setPurchaseId(orderProduct.getPurchase().getId());
        dto.setProductId(orderProduct.getProduct().getId());
        return dto;
    }
}