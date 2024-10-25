package br.com.sps.services.impl;

import br.com.sps.dtos.security.AccountCredentialsDTO;
import br.com.sps.dtos.security.TokenDTO;
import br.com.sps.repository.UserRepository;
import br.com.sps.security.jwt.JwtTokenProvider;
import br.com.sps.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository repository;

    @Override
    public ResponseEntity signin(AccountCredentialsDTO data) {
        try {
            var username = data.userName();
            var password = data.password();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            TokenDTO tokenResponse = null;

            var user = repository.findByUserName(username);

            if ( user != null){
                var token = tokenProvider.createAcessToken(username,user.getRoles());
                var tokenDTO = new TokenDTO(
                        token.userName(),
                        token.authenticated(),
                        token.createdAt(),
                        token.expiration(),
                        token.acessToken(),
                        token.refreshToken()
                );

                tokenResponse = tokenDTO;
            }

            return ResponseEntity.ok(tokenResponse);
        }catch (Exception e){
            throw new BadCredentialsException("invalid username/password supplied.");
        }
    }
}
