package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.DTO.BrandDTO;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDTO> brandDTOs = new java.util.ArrayList<>();

        for (Brand brand : brands) {
            brandDTOs.add(convertToDTO(brand));
        }

        return brandDTOs;
    }

    public BrandDTO getBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marque introuvable avec l'id " + id));
        return convertToDTO(brand);
    }

    private BrandDTO convertToDTO(Brand brand) {
        BrandDTO dto = new BrandDTO();
        dto.setId(brand.getId());
        dto.setLabel(brand.getLabel());
        dto.setSlug(brand.getSlug());
        dto.setLogo(brand.getLogo());
        return dto;
    }
}