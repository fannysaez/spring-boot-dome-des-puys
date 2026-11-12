package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Repository.BrandRepository;
import fr.simplon.domedespuys.Service.Interfaces.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements IBrandService {

    private BrandRepository brandRepository;

    @Override
    public Brand create(BrandDTO dto) {
        Brand brand = new Brand();
        brand.setLabel(dto.label);
        brand.setLogo(dto.logo);
        brand.setSlug(generateSlug(dto.label));
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(String id, BrandDTO dto) {
        Brand brand = getById(id);
        if (brand != null) {
            brand.setLabel(dto.label);
            brand.setLogo(dto.logo);
            brand.setSlug(generateSlug(dto.label));
            brandRepository.save(brand);
        }
        return brand;
    }

    @Override
    public Brand getById(String id) {
        return brandRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public List<Brand> getCollection() {
        return brandRepository.findAll();
    }

    @Override
    public boolean delete(String id) {
        try {
            brandRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String generateSlug(String label) {
        return label.trim().toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
    }
}