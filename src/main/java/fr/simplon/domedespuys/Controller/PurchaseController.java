package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseService;
import fr.simplon.domedespuys.Views.PurchaseView;
import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(PurchaseView.PurchaseDetailView.class)
    public Purchase createPurchase(@Valid @RequestBody PurchasePostDTO dto) {
        return purchaseService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetailView.class)
    public Purchase updatePurchase(@PathVariable String id, @Valid @RequestBody PurchasePutDTO dto) {
        return purchaseService.update(id, dto);
    }
}