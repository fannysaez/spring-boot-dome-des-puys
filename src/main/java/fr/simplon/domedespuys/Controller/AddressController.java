package fr.simplon.domedespuys.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Repository.AddressRepository;
import fr.simplon.domedespuys.Views.AddressView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    @JsonView(AddressView.AddressListView.class)
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse introuvable avec l'id " + id));
    }
}