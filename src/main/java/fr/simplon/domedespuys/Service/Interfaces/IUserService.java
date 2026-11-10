package fr.simplon.domedespuys.Service.Interfaces;

import fr.simplon.domedespuys.Entity.User;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;

public interface IUserService extends
        ICreate<User, UserPostDTO>,
        IUpdate<User, UserPutDTO>,
        IDelete,
        IGetItem<User>
{
}