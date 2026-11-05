package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.DTO.ImageDTO;
import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<ImageDTO> getAllImages() {
        List<Image> images = imageRepository.findAll();
        List<ImageDTO> imageDTOs = new java.util.ArrayList<>();

        for (Image image : images) {
            imageDTOs.add(convertToDTO(image));
        }

        return imageDTOs;
    }
    public ImageDTO getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image introuvable avec l'id " + id));
        return convertToDTO(image);
    }

    private ImageDTO convertToDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setPath(image.getPath());
        dto.setExtension(image.getExtension());
        dto.setDefault(image.isDefault());
        dto.setProductId(image.getProduct().getId());
        return dto;
    }
}