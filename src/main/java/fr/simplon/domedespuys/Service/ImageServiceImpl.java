package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Repository.ImageRepository;
import fr.simplon.domedespuys.Service.Interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {

    private ImageRepository imageRepository;

    @Override
    public Image create(ImageDTO dto, Product product) {
        Image image = new Image();
        image.setPath(dto.path);
        image.setDefault(dto.isDefault);

        String extension = dto.path.substring(dto.path.lastIndexOf('.') + 1);
        image.setExtension(extension);

        image.setProduct(product);

        return imageRepository.save(image);
    }

    @Override
    public boolean delete(String id) {
        try {
            imageRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}