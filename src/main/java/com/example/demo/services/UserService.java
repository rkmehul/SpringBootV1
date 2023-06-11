package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.exception.ETAuthException;

public interface UserService {
    
    User validateUser(String email , String password) throws ETAuthException ;
    User registerUser(String firstName,String lastName , String email , String password) throws ETAuthException;

}
