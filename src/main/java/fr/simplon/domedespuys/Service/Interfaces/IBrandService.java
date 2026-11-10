package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.Entity.Brand;

public interface IBrandService extends
        ICreate<Brand, BrandDTO>,
        IUpdate<Brand, BrandDTO>,
        ICollection<Brand>,
        IGetItem<Brand>,
        IDelete
{
}