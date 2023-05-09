package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rafal.bloodindungeon.user.exception.DaoException;
import pl.rafal.bloodindungeon.user.exception.ServiceLayerException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void saveUser(String username, String characterClass, String password, String email) throws ServiceLayerException {

        if (password == null || password.isEmpty()) {
            password = String.valueOf(UUID.randomUUID());
        }
        User user = buildUser(username, characterClass, password, email);
        save(user);
    }

    public void save(User user) throws ServiceLayerException {
        try {
            userDao.saveUser(user);
        } catch (DaoException ex) {
            throw new ServiceLayerException(ex.getMessage());
        }
    }

    public User buildUser(String username, String characterClass, String password, String email) {

        // powinien tu być password encoder
        User user = User.builder()
                .username(username)
                .characterClass(CharacterClass.valueOf(characterClass))
                .userBalance(100.0)
                .userLvl(1)
                .attack(1)
                .defence(1)
                .exp(1000)
                .hp(100)
                .intelligence(1)
                .password(password)
                .email(email)
                .build();
        return user;
    }

    public boolean deleteUser(int id) {
        return userDao.deleteUserById(id);
    }

    public void updateUserBalance(String username, Double money){
         userDao.updateUserBalance(username, money);
    }

//    void registerUser(RegistrationUser registrationUser) {
//        User preparedNewUser = RegistrationUserToUserConverter.convert(registrationUser);
//        saveUser(preparedNewUser);
//    }
}
