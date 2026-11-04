package fr.simplon.domedespuys.Config;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import fr.simplon.domedespuys.Entity.Brand;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.BrandRepository;
import fr.simplon.domedespuys.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private BrandRepository brandRepository;

    @Override
    public void run(String... args) {
        createUsers();
        createBrands();
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

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        return random.nextInt(max) < expected;
    }

}