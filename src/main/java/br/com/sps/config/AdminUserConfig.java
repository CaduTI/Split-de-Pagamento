package br.com.sps.config;

import br.com.sps.model.Role;
import br.com.sps.model.User;
import br.com.sps.repository.RoleRepository;
import br.com.sps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByDescription(Role.Values.Admin.name());
        var userAdmin = userRepository.findByUserName("adminSwiftPay");

        userAdmin.ifPresentOrElse(

            (user) -> {
                System.out.println("Admin exist.");
            },
            () -> {
                var user = new User();
                user.setUserName("adminSwiftPay");
                user.setPassword("admin123");
                user.setRoles(Set.of(roleAdmin));

                userRepository.save(user);
            }

        );
    }
}
