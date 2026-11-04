package fr.simplon.domedespuys.Config;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import fr.simplon.domedespuys.Entity.Image;
import fr.simplon.domedespuys.Entity.Product;
import fr.simplon.domedespuys.Entity.Address;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.ImageRepository;
import fr.simplon.domedespuys.Repository.ProductRepository;
import fr.simplon.domedespuys.Repository.AddressRepository;
import fr.simplon.domedespuys.Repository.BrandRepository;
import fr.simplon.domedespuys.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class DataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private ImageRepository imageRepository;

    public DataLoaderConfig(UserRepository userRepository, BrandRepository brandRepository,
                            AddressRepository addressRepository, ProductRepository productRepository,
                            ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(String... args) {
        createUsers();
        createBrands();
        createAddresses();
        createProducts();
        createImages();
    }

    private void createUsers() {
        if (userRepository.count() == 0) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());

                String email = faker.internet().emailAddress(
                        (user.getFirstname() + "." + user.getLastname()).toLowerCase()
                );
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                user.setRole(hasProbability(1, 20) ? "ADMIN" : "CLIENT");

                if (hasProbability(2, 3)) {
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }

                LocalDateTime createdAt = new java.sql.Date(faker.date().birthday(0, 5).getTime())
                        .toLocalDate().atTime(0, 0);
                user.setCreatedAt(createdAt);

                userRepository.save(user);
            }
        }
    }

    private void createBrands() {
        if (brandRepository.count() == 0) {
            Faker faker = new Faker(Locale.of("fr"));
            Slugify slugify = Slugify.builder().build();

            for (int i = 0; i < 50; i++) {
                Brand brand = new Brand();
                String label = faker.company().name();
                brand.setLabel(label);
                brand.setSlug(slugify.slugify(label));
                if (hasProbability(1, 2)) {
                    brand.setLogo("https://picsum.photos/seed/" + slugify.slugify(label) + "/200");
                }
                brandRepository.save(brand);
            }
        }
    }

    private void createAddresses() {
        if (addressRepository.count() == 0) {
            Faker faker = new Faker(Locale.of("fr"));
            List<User> users = userRepository.findAll();

            for (int i = 0; i < 120; i++) {
                Address address = new Address();
                address.setLine(faker.address().streetAddress());
                if (hasProbability(1, 4)) {
                    address.setExtraLine(faker.address().secondaryAddress());
                }
                address.setCity(faker.address().city());
                address.setZipCode(faker.address().zipCode());
                address.setCountry(faker.address().country());

                if (hasProbability(1, 2)) {
                    address.setPhone(faker.phoneNumber().phoneNumber());
                }
                address.setFirstname(faker.name().firstName());
                address.setLastname(faker.name().lastName());

                User randomUser = users.get(faker.number().numberBetween(0, users.size()));
                address.setUser(randomUser);

                LocalDateTime createdAt = new java.sql.Date(faker.date().birthday(0, 5).getTime())
                        .toLocalDate().atTime(0, 0);
                address.setCreatedAt(createdAt);

                addressRepository.save(address);
            }
        }
    }

    private void createProducts() {
        if (productRepository.count() == 0) {
            Faker faker = new Faker(Locale.of("fr"));
            Slugify slugify = Slugify.builder().build();
            List<Brand> brands = brandRepository.findAll();

            for (int i = 0; i < 180; i++) {
                Product product = new Product();
                String label = faker.commerce().productName();
                product.setLabel(label);
                product.setSlug(slugify.slugify(label + "-" + i));

                if (hasProbability(3, 4)) {
                    product.setDescription(faker.lorem().paragraph());
                }

                BigDecimal price = new BigDecimal(faker.commerce().price());
                product.setPrice(price);

                Brand randomBrand = brands.get(faker.number().numberBetween(0, brands.size()));
                product.setBrand(randomBrand);

                LocalDateTime createdAt = new java.sql.Date(faker.date().birthday(0, 5).getTime())
                        .toLocalDate().atTime(0, 0);
                product.setCreatedAt(createdAt);

                productRepository.save(product);
            }
        }
    }

    private void createImages() {
        if (imageRepository.count() == 0) {
            Faker faker = new Faker(Locale.of("fr"));
            List<Product> products = productRepository.findAll();

            for (Product product : products) {
                int nbImages = faker.number().numberBetween(1, 4);

                for (int i = 0; i < nbImages; i++) {
                    Image image = new Image();
                    image.setPath("https://picsum.photos/seed/" + product.getSlug() + "-" + i + "/400");
                    image.setExtension("jpg");
                    image.setDefault(i == 0);
                    image.setProduct(product);

                    imageRepository.save(image);
                }
            }
        }
    }

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        return random.nextInt(max) < expected;
    }

}