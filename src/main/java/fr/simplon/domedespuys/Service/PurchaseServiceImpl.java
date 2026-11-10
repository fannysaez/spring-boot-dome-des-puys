package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {

    @Override
    public Purchase create(PurchasePostDTO dto) {
        // Penser au createdAt, status PENDING, user (lambda), number PUR-ANNEE-0000ID_USER + PurchaseProduct
        return null;
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        return null;
    }

    @Override
    public Purchase getById(String id) {
        return null;
    }

    @Override
    public List<Purchase> getCollection() {
        return null;
    }
}