package com.minhhuu.banhang.repo;

import com.minhhuu.banhang.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TestRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(Test test){
        String sql="INSERT INTO test (id,name) VALUES (?,?)";
        jdbcTemplate.update(sql,test.getId(),test.getName());
    }
    public List<Test> findAll() {
        String sql = "SELECT * FROM test";
        return jdbcTemplate.query(sql, new RowMapper<Test>() {
            @Override
            public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
                Test t=new Test();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                return t;
            }
        });
    }

    public Test findById(Long id) {
        String sql = "SELECT * FROM test WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},(rs, rowNum) -> {
            Test t=new Test();
            t.setId(rs.getInt(1));
            t.setName(rs.getString(2));
            return  t;
        });
    }

    public void update(Test user) {
        String sql = "UPDATE users SET name = ?WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
