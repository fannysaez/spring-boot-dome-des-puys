package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.DTO.ProductDTO;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new java.util.ArrayList<>();

        for (Product product : products) {
            productDTOs.add(convertToDTO(product));
        }

        return productDTOs;
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable avec l'id " + id));
        return convertToDTO(product);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setLabel(product.getLabel());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setSlug(product.getSlug());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setBrandId(product.getBrand().getId());
        return dto;
    }
}