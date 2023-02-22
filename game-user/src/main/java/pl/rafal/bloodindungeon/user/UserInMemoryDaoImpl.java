package pl.rafal.bloodindungeon.user;

import java.util.*;

public class UserInMemoryDaoImpl implements UserDao {

    Map<Integer, User> users = new HashMap<>();

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> usersList = users.values().stream().toList();
        for (User user : usersList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new RuntimeException("User with this username doesn't exist");
    }

    @Override
    public void saveUser(User user) {
        UUID uuid = UUID.randomUUID();
        int id = Integer.getInteger(uuid.toString());
        users.put(id,user);
    }


    @Override
    public boolean deleteUserById(int id) {
        users.remove(id);
        User user = users.get(id);
        return user != null;
    }

    @Override
    public void deleteUserByUsername(String username) {
        List<User> usersList = users.values().stream().toList();
        for (User user : usersList) {
            if (user.getUsername().equals(username)) {
                users.remove(user.getId());
            }
        }
        throw new RuntimeException("User with this username doesn't exist");
    }

    @Override
    public Double getUserBalance(int id) {
        return users.get(id).getUserBalance();
    }

    @Override
    public int getUserLevel(int id) {
        return users.get(id).getUserLvl();
    }

    @Override
    public String getUserCharacterClass(int id) {
        return users.get(id).getCharacterClass().toString();
    }

    // TODO Zrobić jakieś wczytywanie sekwencji
    private int getId() {
        return 2;
    }
}
