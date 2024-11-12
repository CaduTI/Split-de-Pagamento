package br.com.sps.services;

import br.com.sps.dtos.CreateUserDTO;
import br.com.sps.dtos.response.UserResponse;
import br.com.sps.model.User;

import java.util.Optional;

public interface Userservice {

    public Optional<User> loadUserByUsername(String username);
    public User createuser(CreateUserDTO dto);

}
