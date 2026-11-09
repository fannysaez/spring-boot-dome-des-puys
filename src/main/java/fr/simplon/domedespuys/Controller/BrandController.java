package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Repository.BrandRepository;
import fr.simplon.domedespuys.Views.BrandView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    @JsonView(BrandView.BrandListView.class)
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand getBrandById(@PathVariable Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marque introuvable avec l'id " + id));
    }
}