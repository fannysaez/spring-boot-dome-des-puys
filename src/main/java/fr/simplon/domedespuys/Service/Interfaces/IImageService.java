package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.dto.ImageDTO;

public interface IImageService extends IDelete {
    Image create(ImageDTO dto, Product product);
}