package br.com.sps.services;

import br.com.sps.dtos.security.AccountCredentialsDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity signin(AccountCredentialsDTO data);

}
