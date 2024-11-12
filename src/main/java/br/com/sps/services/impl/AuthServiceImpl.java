package br.com.sps.services.impl;

import br.com.sps.dtos.request.LoginRequest;
import br.com.sps.dtos.response.LoginResponse;
import br.com.sps.model.Role;
import br.com.sps.repository.UserRepository;

import br.com.sps.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    JwtEncoder jwtEncoder;

    @Autowired
    UserRepository repository;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest data) {
        try {
            var user = repository.findByUserName(data.userName());
             if (user.isEmpty() || !user.get().isLoginCorrect(data, passwordEncoder)) {
                throw new BadCredentialsException("user or password is invalid!");
            }

            var now = Instant.now();
            var expiresIn = 300L;

            var scopes = user.get().getRoles()
                    .stream()
                    .map(Role::getDescription)
                    .collect(Collectors.joining(" "));

            var claims = JwtClaimsSet.builder()
                    .issuer("mybackend")
                    .subject(user.get().getId().toString())
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiresIn))
                    .claim("scope", scopes)
                    .build();
            var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();;
            return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
        }catch (Exception e){
            throw new BadCredentialsException("invalid username/password supplied.");
        }
    }
}
