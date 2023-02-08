package pl.rafal.bloodindungeon.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class UserJdbcDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserJdbcDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<User> getAllUsers() {
        String sql = """
                    SELECT * FROM user
                """;
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void deleteUserByUsername(String username) {

    }

    @Override
    public Double getUserBalance(int id) {
        return null;
    }

    @Override
    public int getUserLevel(int id) {
        return 0;
    }

    @Override
    public String getUserCharacterClass(int id) {
        return null;
    }
}
