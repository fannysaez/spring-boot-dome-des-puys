package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Repository.UserRepository;
import fr.simplon.domedespuys.Service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        User user = new User();
        user.setEmail(dto.email);
        user.setPassword(dto.password);
        user.setFirstname(dto.firstname);
        user.setLastname(dto.lastname);
        user.setRole("CLIENT");
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        User user = getById(id);
        if (user != null) {
            user.setFirstname(dto.firstname);
            user.setLastname(dto.lastname);
            user.setPhone(dto.phone);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public boolean delete(String id) {
        User user = getById(id);
        if (user == null) {
            return false;
        }
        user.setEmail("anonyme" + user.getId() + "@anonyme.fr");
        user.setFirstname("Anonyme");
        user.setLastname("Anonyme");
        user.setPhone(null);
        user.setPassword("ANONYMISE");
        userRepository.save(user);
        return true;
    }
}