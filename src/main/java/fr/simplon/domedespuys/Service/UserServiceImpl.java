package fr.simplon.domedespuys.Service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.Service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    @Override
    public User create(UserPostDTO dto) {
        // Penser au createdAt
        return null;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        // Pas un vrai delete : anonymiser les champs de l'utilisateur
        return false;
    }
}