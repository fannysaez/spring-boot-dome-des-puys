package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.dto.AddressDTO;

public interface IAddressService extends
        ICreate<Address, AddressDTO>,
        IUpdate<Address, AddressDTO>,
        IDelete
{
}