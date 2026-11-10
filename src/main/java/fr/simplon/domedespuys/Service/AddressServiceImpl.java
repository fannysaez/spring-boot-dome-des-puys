package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Service.Interfaces.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    @Override
    public Address create(AddressDTO dto) {
        // Penser au createdAt + user (lambda pour le moment)
        return null;
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}