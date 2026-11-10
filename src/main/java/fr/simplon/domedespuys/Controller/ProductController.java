package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Service.Interfaces.IProductService;
import fr.simplon.domedespuys.Views.ProductView;
import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getAllProducts() {
        return productService.getCollection();
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product getProductById(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    @JsonView(ProductView.ProductDetailView.class)
    public Product createProduct(@RequestBody ProductPostDTO dto) {
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product updateProduct(@PathVariable String id, @RequestBody ProductPutDTO dto) {
        return productService.update(id, dto);
    }
}