package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Service.Interfaces.IProductService;
import fr.simplon.domedespuys.Views.ProductView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}