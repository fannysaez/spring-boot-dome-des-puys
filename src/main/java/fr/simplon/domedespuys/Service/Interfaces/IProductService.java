package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;

public interface IProductService extends
        ICreate<Product, ProductPostDTO>,
        IUpdate<Product, ProductPutDTO>,
        IGetItem<Product>,
        ICollection<Product>
{
}