package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Service.Interfaces.IBrandService;
import fr.simplon.domedespuys.Views.BrandView;
import fr.simplon.domedespuys.dto.BrandDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private IBrandService brandService;

    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    @JsonView(BrandView.BrandListView.class)
    public List<Brand> getAllBrands() {
        return brandService.getCollection();
    }

    @GetMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand getBrandById(@PathVariable String id) {
        return brandService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(BrandView.BrandDetailView.class)
    public Brand createBrand(@Valid @RequestBody BrandDTO dto) {
        return brandService.create(dto);
    }
    @PutMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand updateBrand(@PathVariable String id, @Valid @RequestBody BrandDTO dto) {
        return brandService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBrand(@PathVariable String id) {
        return brandService.delete(id);
    }
}