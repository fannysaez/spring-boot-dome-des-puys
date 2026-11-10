package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.Entity.OrderProduct;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.dto.PurchaseProductDTO;

public interface ICreatePurchaseProduct {

    OrderProduct create(PurchaseProductDTO dto, Purchase purchase);

}