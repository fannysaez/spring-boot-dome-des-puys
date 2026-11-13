package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.Exception.InvalidAddressException;
import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Entity.EnumPurchaseStatus;
import fr.simplon.domedespuys.Entity.OrderProduct;
import fr.simplon.domedespuys.Entity.Purchase;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.AddressRepository;
import fr.simplon.domedespuys.Repository.PurchaseRepository;
import fr.simplon.domedespuys.Repository.UserRepository;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseProductService;
import fr.simplon.domedespuys.Service.Interfaces.IPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {

    private PurchaseRepository purchaseRepository;
    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private IPurchaseProductService purchaseProductService;

    @Override
    public Purchase create(PurchasePostDTO dto) {
        Address address = addressRepository.findById(dto.addressId)
                .orElseThrow(InvalidAddressException::new);
        User lambdaUser = userRepository.findAll().get(0);

        Purchase purchase = new Purchase();
        purchase.setCreatedAt(LocalDateTime.now());
        purchase.setStatus(EnumPurchaseStatus.PENDING);
        purchase.setUser(lambdaUser);
        purchase.setAddress(address);

        int year = LocalDateTime.now().getYear();
        long count = purchaseRepository.count() + 1;
        String number = String.format("PUR-%d-%04d", year, count);
        purchase.setNumber(number);

        purchase = purchaseRepository.save(purchase);

        if (dto.purchaseProducts != null) {
            for (PurchaseProductDTO ppDto : dto.purchaseProducts) {
                OrderProduct orderProduct = purchaseProductService.create(ppDto, purchase);
                purchase.getOrderProducts().add(orderProduct);
            }
        }

        return purchase;
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        Purchase purchase = getById(id);
        if (purchase != null) {
            purchase.setStatus(EnumPurchaseStatus.valueOf(dto.status));
            purchaseRepository.save(purchase);
        }
        return purchase;
    }

    @Override
    public Purchase getById(String id) {
        return purchaseRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public List<Purchase> getCollection() {
        return purchaseRepository.findAll();
    }
}