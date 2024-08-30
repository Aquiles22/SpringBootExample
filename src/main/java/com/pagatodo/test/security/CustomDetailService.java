package com.pagatodo.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.pagatodo.test.dao.User;
import com.pagatodo.test.repository.UserRepository;

@Service
public class CustomDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    private User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail = userRepository.findByUsername(username);
        if(userDetail != null){
            return new org.springframework.security.core.userdetails.User(userDetail.getUsername(), userDetail.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }

    public User getUserDetail(){
        return userDetail;
    }
    
}
