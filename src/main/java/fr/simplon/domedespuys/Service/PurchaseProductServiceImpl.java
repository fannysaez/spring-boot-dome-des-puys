package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.Entity.OrderProduct;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseProductServiceImpl implements IPurchaseProductService {

    @Override
    public OrderProduct create(PurchaseProductDTO dto, Purchase purchase) {
        return null;
    }
}