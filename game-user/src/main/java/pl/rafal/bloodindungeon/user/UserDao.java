package pl.rafal.bloodindungeon.user;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(UUID id);
    User getUserByUsername(String username);
    void saveUser(User user);
    void deleteUserById(UUID id);
    void deleteUserByUsername(String username);
    Double getUserBalance(UUID id);
    int getUserLevel(UUID id);
    String getUserCharacterClass(UUID id);
}
