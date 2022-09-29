package pl.rafal.bloodindungeon.user;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByUsername(String username);
    void saveUser(User user);
    void deleteUserById(int id);
    void deleteUserByUsername(String username);
    Double getUserBalance(int id);
    int getUserLevel(int id);
    String getUserCharacterClass(int id);
}
