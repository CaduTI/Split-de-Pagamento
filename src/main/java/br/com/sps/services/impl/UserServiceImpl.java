package br.com.sps.services.impl;

import br.com.sps.dtos.CreateUserDTO;
import br.com.sps.model.Role;
import br.com.sps.model.User;
import br.com.sps.repository.RoleRepository;
import br.com.sps.repository.UserRepository;
import br.com.sps.services.Userservice;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements Userservice {


    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    public Optional<User> loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username);


    }
    public User createuser(CreateUserDTO dto){
        var basicRole = roleRepository.findByDescription(Role.Values.Subordinate.name());

        var userFromDb = userRepository.findByUserName(dto.userName());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = new User();
        user.setUserName(dto.userName());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRoles(Set.of(basicRole));

       return userRepository.save(user);
    }
}
