package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Service.Interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {

    @Override
    public Image create(ImageDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}