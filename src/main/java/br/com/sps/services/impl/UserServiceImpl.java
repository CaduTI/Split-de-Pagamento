package br.com.sps.services.impl;

import br.com.sps.model.User;
import br.com.sps.repository.UserRepository;
import br.com.sps.services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements Userservice, UserDetailsService {

    @Autowired
    UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUserName(username);

        if(username != null){
            return user;

        }else{
            throw new UsernameNotFoundException("Username"+ username + "not found.");
        }
    }

    @Override
    public User findById() {
        return null;
    }
}
