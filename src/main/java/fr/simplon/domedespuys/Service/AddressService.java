package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.DTO.AddressDTO;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDTO> addressDTOs = new java.util.ArrayList<>();

        for (Address address : addresses) {
            addressDTOs.add(convertToDTO(address));
        }

        return addressDTOs;
    }

    private AddressDTO convertToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setLine(address.getLine());
        dto.setExtraLine(address.getExtraLine());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setCountry(address.getCountry());
        dto.setPhone(address.getPhone());
        dto.setFirstname(address.getFirstname());
        dto.setLastname(address.getLastname());
        dto.setCreatedAt(address.getCreatedAt());
        dto.setUserId(address.getUser().getId());
        return dto;
    }
}