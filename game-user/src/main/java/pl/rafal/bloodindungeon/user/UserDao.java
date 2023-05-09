package pl.rafal.bloodindungeon.user;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);
    User getUserByUsername(String username);
    void saveUser(User user);
    boolean deleteUserById(int id);
    void deleteUserByUsername(String username);
    Double getUserBalance(int id);
    int getUserLevel(int id);
    String getUserCharacterClass(int id);

    void updateUserBalance(String username, Double money);
}
