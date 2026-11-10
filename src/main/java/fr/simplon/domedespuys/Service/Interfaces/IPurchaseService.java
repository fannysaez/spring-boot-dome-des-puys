package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;

public interface IPurchaseService extends
        ICreate<Purchase, PurchasePostDTO>,
        IUpdate<Purchase, PurchasePutDTO>,
        IGetItem<Purchase>,
        ICollection<Purchase>
{
}