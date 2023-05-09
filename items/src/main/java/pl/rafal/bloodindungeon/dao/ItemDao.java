package pl.rafal.bloodindungeon.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemDao {

    private final JdbcTemplate jdbcTemplate;

    public void getAllItems(){
        String sql = "select * from items";
    }


}
