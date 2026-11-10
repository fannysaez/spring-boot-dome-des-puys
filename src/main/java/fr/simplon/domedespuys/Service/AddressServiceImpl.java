package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.AddressRepository;
import fr.simplon.domedespuys.Repository.UserRepository;
import fr.simplon.domedespuys.Service.Interfaces.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;

    @Override
    public Address create(AddressDTO dto) {
        Address address = new Address();
        address.setLine(dto.line);
        address.setExtraLine(dto.extraLine);
        address.setZipCode(dto.zipCode);
        address.setCity(dto.city);
        address.setCountry(dto.country);
        address.setPhone(dto.phone);
        address.setFirstname(dto.firstname);
        address.setLastname(dto.lastname);
        address.setCreatedAt(LocalDateTime.now());

        User lambdaUser = userRepository.findAll().get(0);
        address.setUser(lambdaUser);

        return addressRepository.save(address);
    }

    @Override
    public Address getById(String id) {
        return addressRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        Address address = getById(id);
        if (address != null) {
            address.setLine(dto.line);
            address.setExtraLine(dto.extraLine);
            address.setZipCode(dto.zipCode);
            address.setCity(dto.city);
            address.setCountry(dto.country);
            address.setPhone(dto.phone);
            address.setFirstname(dto.firstname);
            address.setLastname(dto.lastname);
            addressRepository.save(address);
        }
        return address;
    }

    @Override
    public boolean delete(String id) {
        try {
            addressRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}