package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Service.Interfaces.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    @Override
    public Product create(ProductPostDTO dto) {
        // Penser au createdAt
        return null;
    }

    @Override
    public Product update(String id, ProductPutDTO dto) {
        return null;
    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public List<Product> getCollection() {
        return null;
    }
}