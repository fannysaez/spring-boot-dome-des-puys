package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.DTO.PurchaseDTO;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<PurchaseDTO> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        List<PurchaseDTO> purchaseDTOs = new java.util.ArrayList<>();

        for (Purchase purchase : purchases) {
            purchaseDTOs.add(convertToDTO(purchase));
        }

        return purchaseDTOs;
    }

    private PurchaseDTO convertToDTO(Purchase purchase) {
        PurchaseDTO dto = new PurchaseDTO();
        dto.setId(purchase.getId());
        dto.setNumber(purchase.getNumber());
        dto.setStatus(purchase.getStatus());
        dto.setCreatedAt(purchase.getCreatedAt());
        dto.setUserId(purchase.getUser().getId());
        dto.setAddressId(purchase.getAddress().getId());
        return dto;
    }
}