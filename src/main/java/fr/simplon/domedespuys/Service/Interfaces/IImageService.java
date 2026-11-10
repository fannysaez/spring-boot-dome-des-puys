package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.Entity.Image;

public interface IImageService extends
        ICreate<Image, ImageDTO>,
        IDelete
{
}