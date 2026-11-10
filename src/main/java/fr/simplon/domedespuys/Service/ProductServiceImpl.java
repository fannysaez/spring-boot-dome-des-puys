package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Repository.BrandRepository;
import fr.simplon.domedespuys.Repository.ProductRepository;
import fr.simplon.domedespuys.Service.Interfaces.IImageService;
import fr.simplon.domedespuys.Service.Interfaces.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private BrandRepository brandRepository;
    private IImageService imageService;

    @Override
    public Product create(ProductPostDTO dto) {
        Brand brand = brandRepository.findByLabel(dto.brand).orElse(null);
        if (brand == null) {
            brand = new Brand();
            brand.setLabel(dto.brand);
            brand.setSlug(generateSlug(dto.brand));
            brand = brandRepository.save(brand);
        }

        Product product = new Product();
        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setSlug(generateSlug(dto.label));
        product.setCreatedAt(LocalDateTime.now());
        product.setBrand(brand);

        product = productRepository.save(product);

        if (dto.images != null) {
            for (ImageDTO imageDto : dto.images) {
                Image image = imageService.create(imageDto, product);
                product.getImages().add(image);
            }
        }

        return product;
    }

    @Override
    public Product update(String id, ProductPutDTO dto) {
        Product product = getById(id);
        if (product != null) {
            Brand brand = brandRepository.findByLabel(dto.brand).orElse(null);
            if (brand == null) {
                brand = new Brand();
                brand.setLabel(dto.brand);
                brand.setSlug(generateSlug(dto.brand));
                brand = brandRepository.save(brand);
            }

            product.setLabel(dto.label);
            product.setDescription(dto.description);
            product.setPrice(dto.price);
            product.setSlug(generateSlug(dto.label));
            product.setBrand(brand);

            productRepository.save(product);

            List<Image> oldImages = new ArrayList<>(product.getImages());
            for (Image oldImage : oldImages) {
                imageService.delete(String.valueOf(oldImage.getId()));
            }
            product.getImages().clear();

            if (dto.images != null) {
                for (ImageDTO imageDto : dto.images) {
                    Image image = imageService.create(imageDto, product);
                    product.getImages().add(image);
                }
            }
        }
        return product;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    private String generateSlug(String label) {
        return label.trim().toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
    }
}