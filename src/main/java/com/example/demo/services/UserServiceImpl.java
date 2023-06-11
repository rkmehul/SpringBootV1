package com.example.demo.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.exception.ETAuthException;
import com.example.demo.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
 @Autowired
 UserRepository userRepository;
    @Override
    public User validateUser(String email, String password) throws ETAuthException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateUser'");
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException {
         Pattern pattern = Pattern.compile("^(.+)@(.+)$");
         if(email != null) 
             email = email.toLowerCase();
             if(!pattern.matcher(email).matches())
                throw new ETAuthException("Invalid Email Format");
             Integer count = userRepository.getCountByEmail(email);
             if(count > 0)
                throw new ETAuthException("Email Already in use");
        
          Integer userId = userRepository.create(firstName, lastName, email, password);
          return (User)userRepository.findById(userId);
         
    }
    
}
