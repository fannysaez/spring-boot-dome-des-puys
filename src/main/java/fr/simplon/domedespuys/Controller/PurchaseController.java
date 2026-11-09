package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Repository.PurchaseRepository;
import fr.simplon.domedespuys.Views.PurchaseView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping
    @JsonView(PurchaseView.PurchaseListView.class)
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetailView.class)
    public Purchase getPurchaseById(@PathVariable Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable avec l'id " + id));
    }
}