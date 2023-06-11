package com.example.demo.repository;


import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;
import com.example.demo.exception.ETAuthException;
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_CREATE = "INSERT INTO ET_USERS (USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD) VALUES(NEXTVAL('ET_USERS_SEQ'),?,?,?,?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT count(*) from ET_USERS WHERE EMAIL = ?";
    private static final String SQL_FIND_BY_ID = "SELECT USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PASSWORD FROM ET_USERS where USER_ID = ?";
     @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws ETAuthException {
       try{
           KeyHolder keyHolder = new GeneratedKeyHolder();
           jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2,lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            return ps;
           }, keyHolder);
           return (Integer)keyHolder.getKeys().get("USER_ID");
       }
       catch(Exception e)
       {
        throw new ETAuthException("Invalid Details");
       }
    }

    @Override
    public User findByEmailIdAndPassword(String email, String password) throws ETAuthException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmailIdAndPassword'");
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId}, userRowMapper);
    }

    private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
     return new User(
        rs.getInt("USER_ID"),
        rs.getString("FIRST_NAME"),
        rs.getString("LAST_NAME"),
        rs.getString("EMAIL"),
        rs.getString("pASSWORD")
     );
    });
    
}