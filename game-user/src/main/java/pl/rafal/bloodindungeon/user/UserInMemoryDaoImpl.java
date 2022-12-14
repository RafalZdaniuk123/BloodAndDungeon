package pl.rafal.bloodindungeon.user;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserInMemoryDaoImpl implements UserDao {

    Map<UUID, User> users = new HashMap<>();

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }

    @Override
    public User getUserById(UUID id) {
        return users.get(id);
    }

    @Override
    public User getUserByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new RuntimeException("User with this username doesn't exist");
    }

    @Override
    public void saveUser(User user) {
        users.put(getId(), user);
    }


    @Override
    public void deleteUserById(UUID id) {
        users.remove(id);
    }

    @Override
    public void deleteUserByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                users.remove(user.getId());
            }
        }
        throw new RuntimeException("User with this username doesn't exist");
    }

    @Override
    public Double getUserBalance(UUID id) {
        return users.get(id).getUserBalance();
    }

    @Override
    public int getUserLevel(UUID id) {
        return users.get(id).getUserLvl();
    }

    @Override
    public String getUserCharacterClass(UUID id) {
        return users.get(id).getCharacterClass().toString();
    }

    private UUID getId() {
        return UUID.randomUUID();
    }
}
