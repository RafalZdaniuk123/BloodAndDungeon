package pl.rafal.bloodindungeon.user;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

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
    public User getUserById(UUID id) {
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
    public void deleteUserById(UUID id) {

    }

    @Override
    public void deleteUserByUsername(String username) {

    }

    @Override
    public Double getUserBalance(UUID id) {
        return null;
    }

    @Override
    public int getUserLevel(UUID id) {
        return 0;
    }

    @Override
    public String getUserCharacterClass(UUID id) {
        return null;
    }
}
