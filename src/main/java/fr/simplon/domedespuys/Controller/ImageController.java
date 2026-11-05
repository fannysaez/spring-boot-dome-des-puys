package fr.simplon.domedespuys.Controller;

import fr.simplon.domedespuys.DTO.ImageDTO;
import fr.simplon.domedespuys.Service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<ImageDTO> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ImageDTO getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }
}