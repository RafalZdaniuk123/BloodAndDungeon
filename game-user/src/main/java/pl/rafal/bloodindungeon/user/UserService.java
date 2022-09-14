package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    User getUserById(UUID id){
        return userDao.getUserById(id);
    }

    User getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }

    void saveUser(User user){
        userDao.saveUser(user);
    }

    void deleteUser(UUID id){
        userDao.deleteUserById(id);
    }

}
