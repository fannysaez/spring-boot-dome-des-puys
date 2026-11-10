package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.Entity.OrderProduct;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Repository.OrderProductRepository;
import fr.simplon.domedespuys.Repository.ProductRepository;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseProductServiceImpl implements IPurchaseProductService {

    private OrderProductRepository orderProductRepository;
    private ProductRepository productRepository;

    @Override
    public OrderProduct create(PurchaseProductDTO dto, Purchase purchase) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setQuantity(dto.qty);
        orderProduct.setPrice(dto.price);

        Product product = productRepository.findById(dto.idProduct).orElse(null);
        orderProduct.setProduct(product);

        orderProduct.setPurchase(purchase);

        return orderProductRepository.save(orderProduct);
    }
}