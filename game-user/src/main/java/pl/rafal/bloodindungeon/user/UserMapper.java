package pl.rafal.bloodindungeon.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getObject("id", UUID.class))
                .username(rs.getString("SURNAME"))
                .password(rs.getString("PASSWORD"))
                .characterClass(CharacterClass.valueOf(rs.getString("CHARACTERCLASS")))
                .userLvl(rs.getInt("USERLVL"))
                .userBalance(rs.getDouble("USERBALANCE"))
                .Exp(rs.getInt("EXP"))
                .hp(rs.getInt("HP"))
                .attack(rs.getInt("ATTACK"))
                .defence(rs.getInt("DEFENCE"))
                .intelligence(rs.getInt("INTELLIGENCE"))
                .build();
    }
}
