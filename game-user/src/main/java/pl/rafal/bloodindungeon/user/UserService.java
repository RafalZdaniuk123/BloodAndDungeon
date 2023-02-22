package pl.rafal.bloodindungeon.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.rafal.bloodindungeon.user.exception.DaoException;
import pl.rafal.bloodindungeon.user.exception.ServiceLayerException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    User getUserById(int id) {
        return userDao.getUserById(id);
    }

    User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void saveUser(String username, String characterClass) throws ServiceLayerException {
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
                // only for tests
                .password("password")
                .build();
        try {
            userDao.saveUser(user);
        } catch (DaoException ex) {
            throw new ServiceLayerException(ex.getMessage());
        }
    }

    public boolean deleteUser(int id) {
        return userDao.deleteUserById(id);
    }

//    void registerUser(RegistrationUser registrationUser) {
//        User preparedNewUser = RegistrationUserToUserConverter.convert(registrationUser);
//        saveUser(preparedNewUser);
//    }
}
