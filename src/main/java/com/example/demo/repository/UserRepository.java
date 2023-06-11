package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.exception.ETAuthException;

public interface UserRepository {

    Integer create(String firstName,String lastName , String email, String password) throws ETAuthException;
    User findByEmailIdAndPassword(String email , String password) throws ETAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
    
}
