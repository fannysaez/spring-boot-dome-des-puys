package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseService;
import fr.simplon.domedespuys.Views.PurchaseView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private IPurchaseService purchaseService;

    public PurchaseController(IPurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    @JsonView(PurchaseView.PurchaseListView.class)
    public List<Purchase> getAllPurchases() {
        return purchaseService.getCollection();
    }

    @GetMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetailView.class)
    public Purchase getPurchaseById(@PathVariable String id) {
        return purchaseService.getById(id);
    }
}