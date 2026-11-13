package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Service.Interfaces.IAddressService;
import fr.simplon.domedespuys.Views.AddressView;
import fr.simplon.domedespuys.dto.AddressDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address getAddressById(@PathVariable String id) {
        return addressService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(AddressView.AddressDetailView.class)
    public Address createAddress(@Valid @RequestBody AddressDTO dto) {
        return addressService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address updateAddress(@PathVariable String id, @Valid @RequestBody AddressDTO dto) {
        return addressService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAddress(@PathVariable String id) {
        return addressService.delete(id);
    }
}