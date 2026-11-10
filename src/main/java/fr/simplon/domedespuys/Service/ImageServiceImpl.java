package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.Service.Interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {

    @Override
    public boolean delete(String id) {
        return false;
    }
}