package pl.rafal.bloodindungeon.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pl.rafal.bloodindungeon.user.exception.RecordNotFoundException;
import pl.rafal.bloodindungeon.user.exception.SaveUserFailedException;


import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserJdbcDao implements UserDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.getJdbcOperations().query(sql, new UserMapper());
    }

    @Override
    public User getUserById(int id) {
        String sql = " SELECT * FROM user WHERE id=:id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(sql, param, new UserMapper());
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = " SELECT * FROM user WHERE surname=?";
        return (User) jdbcTemplate.getJdbcOperations().query(sql, new UserMapper(), username);
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO user (USERNAME, PASSWORD, CHARACTERCLASS, USERLVL, USERBALANCE, EXP, HP, ATTACK, DEFENCE, INTELLIGENCE)" +
                " VALUES (:username,:password,:characterClass,:userLvl,:userBalance,:exp,:hp,:attack,:defence,:intelligence)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", user.getUsername());
        params.addValue("password", user.getPassword());
        params.addValue("characterClass", user.getCharacterClass().toString());
        params.addValue("userLvl", user.getUserLvl());
        params.addValue("userBalance", user.getUserBalance());
        params.addValue("exp", user.getExp());
        params.addValue("hp", user.getHp());
        params.addValue("attack", user.getAttack());
        params.addValue("defence", user.getDefence());
        params.addValue("intelligence", user.getIntelligence());

        int update = jdbcTemplate.update(sql, params);
        if (update != 1) {
            throw new SaveUserFailedException(
                    "User can't be saved. Number of operations is: " + update + " but expected 1");
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        int update = jdbcTemplate.getJdbcOperations().update(sql, id);
        return update == 1;
    }

    // margin-left: 50% - połowa zdjęcia (1/2 image)
    @Override
    public void deleteUserByUsername(String username) {
        String sql = "DELETE FROM user WHERE username = ?";
        jdbcTemplate.getJdbcOperations().update(sql, username);
    }

    @Override
    public Double getUserBalance(int id) {
        String sql = "SELECT USERBALANCE FROM user WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return jdbcTemplate.query(sql, param, rs -> {
            if (rs.next()) {
                return rs.getDouble("USERBALANCE");
            }
            throw new RecordNotFoundException("User balance was not found");
        });
    }

    @Override
    public int getUserLevel(int id) {
        String sql = "SELECT USERLVL FROM user WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return jdbcTemplate.query(sql, param, rs -> {
            if (rs.next()) {
                int lvl;
                lvl = rs.getInt("USERLVL");
                if (rs.wasNull()) {
                    lvl = 0;
                }
                return lvl;
            }
            throw new RecordNotFoundException(("User level was not were"));
        });
    }

    @Override
    public String getUserCharacterClass(int id) {
        String sql = "SELECT CHARACTERCLASS FROM user WHERE id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);
        return jdbcTemplate.query(sql, param, rs -> {
            if (rs.next()) {
                return rs.getString("CHARACTERCLASS");
            }
            throw new RecordNotFoundException("User character class was not found");
        });
    }
}
