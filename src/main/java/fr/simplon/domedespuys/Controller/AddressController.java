package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Repository.AddressRepository;
import fr.simplon.domedespuys.Service.Interfaces.IAddressService;
import fr.simplon.domedespuys.Views.AddressView;
import fr.simplon.domedespuys.dto.AddressDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressRepository addressRepository;
    private IAddressService addressService;

    public AddressController(AddressRepository addressRepository, IAddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @GetMapping
    @JsonView(AddressView.AddressListView.class)
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address getAddressById(@PathVariable String id) {
        return addressService.getById(id);
    }

    @PostMapping
    @JsonView(AddressView.AddressDetailView.class)
    public Address createAddress(@RequestBody AddressDTO dto) {
        return addressService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address updateAddress(@PathVariable String id, @RequestBody AddressDTO dto) {
        return addressService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAddress(@PathVariable String id) {
        return addressService.delete(id);
    }
}