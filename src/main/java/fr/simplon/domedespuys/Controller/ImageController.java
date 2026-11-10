package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Repository.ImageRepository;
import fr.simplon.domedespuys.Service.Interfaces.IImageService;
import fr.simplon.domedespuys.Views.ImageView;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageRepository imageRepository;
    private IImageService imageService;

    public ImageController(ImageRepository imageRepository, IImageService imageService) {
        this.imageRepository = imageRepository;
        this.imageService = imageService;
    }

    @GetMapping
    @JsonView(ImageView.ImageListView.class)
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(ImageView.ImageDetailView.class)
    public Optional<Image> getImageById(@PathVariable Long id) {
        return imageRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteImage(@PathVariable String id) {
        return imageService.delete(id);
    }
}