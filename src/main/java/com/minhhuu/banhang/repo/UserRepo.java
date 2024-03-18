package com.minhhuu.banhang.repo;


import com.minhhuu.banhang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(User user){
        String sql="INSERT INTO users (email,username,password,phone,accountname,address) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getEmail(),user.getUsername(),user.getPassword(),user.getPhone(),user.getAccountname(),user.getAddress());

    }
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u=new User();
                u.setUser_id(rs.getInt(1));
                u.setEmail(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setStatus(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setPhone(rs.getString(6));
                u.setRole(rs.getString(7));
                u.setAccountname(rs.getString(8));
                u.setAddress(rs.getString(9));
                return u;
            }
        });
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},(rs, rowNum) -> {
            User u=new User();
            u.setUser_id(rs.getInt(1));
            u.setEmail(rs.getString(2));
            u.setUsername(rs.getString(3));
            u.setStatus(rs.getString(4));
            u.setPassword(rs.getString(5));
            u.setPhone(rs.getString(6));
            u.setRole(rs.getString(7));
            u.setAccountname(rs.getString(8));
            u.setAddress(rs.getString(9));
            return u;
        });
    }
    public  boolean findByName(String username){
        if (username == null) {
            return false; // Trả về false nếu username là null
        }

        String sql = "SELECT count(*) FROM users WHERE accountname = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class,username);
        System.out.println(count);
        return count != null && count > 0;
    }
    public  User findName(String accountname){
     System.out.println(1);
        String sql = "SELECT * FROM users WHERE accountname= ?";
      return   jdbcTemplate.queryForObject(sql,new Object[]{accountname},(rs, rowNum) -> {
            User u=new User();
            u.setUser_id(rs.getInt(1));
            u.setEmail(rs.getString(2));
            u.setUsername(rs.getString(3));
            u.setStatus(rs.getString(4));
            u.setPassword(rs.getString(5));
            u.setPhone(rs.getString(6));
            u.setRole(rs.getString(7));
            u.setAccountname(rs.getString(8));
            u.setAddress(rs.getString(9));
            return u;
        });
    }

    public void update(User user) {

        System.out.println(user);
        String sql = "UPDATE users SET email=?,username=?,status=?,password=?,phone=?,accountname=? WHERE user_id =?";
       int row= jdbcTemplate.update(sql,user.getEmail(),user.getUsername(),user.getStatus(),user.getPassword(),user.getPhone(),user.getAccountname(),user.getUser_id());
       System.out.println(row);
        if(row==0){
            throw new EmptyResultDataAccessException("Không tìm thấy bản ghi với ID: " + user.getUser_id(), 1);
        }
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
      int row=  jdbcTemplate.update(sql, id);
      if(row==0){
          throw new EmptyResultDataAccessException("Không tìm thấy bản ghi với ID: " + id, 1);
      }
    }
}
