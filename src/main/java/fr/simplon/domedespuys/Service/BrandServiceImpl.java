package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Service.Interfaces.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements IBrandService {

    @Override
    public Brand create(BrandDTO dto) {
        return null;
    }

    @Override
    public Brand update(String id, BrandDTO dto) {
        return null;
    }

    @Override
    public Brand getById(String id) {
        return null;
    }

    @Override
    public List<Brand> getCollection() {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}