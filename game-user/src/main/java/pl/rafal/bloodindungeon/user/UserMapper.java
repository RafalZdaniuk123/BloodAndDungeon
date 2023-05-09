package pl.rafal.bloodindungeon.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .username(rs.getString("USERNAME"))
                .password(rs.getString("PASSWORD"))
                .characterClass(CharacterClass.valueOf(rs.getString("CHARACTERCLASS")))
                .userLvl(rs.getInt("USERLVL"))
                .userBalance(rs.getDouble("USERBALANCE"))
                .exp(rs.getInt("EXP"))
                .hp(rs.getInt("HP"))
                .attack(rs.getInt("ATTACK"))
                .defence(rs.getInt("DEFENCE"))
                .intelligence(rs.getInt("INTELLIGENCE"))
                .email(rs.getString("EMAIL"))
                .build();
    }
}
