package br.com.sps.services;

import br.com.sps.dtos.request.LoginRequest;
import br.com.sps.dtos.response.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<LoginResponse> login(LoginRequest data);

}
