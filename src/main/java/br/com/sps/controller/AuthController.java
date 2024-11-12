package br.com.sps.controller;

import br.com.sps.dtos.request.LoginRequest;
import br.com.sps.model.User;
import br.com.sps.services.impl.AuthServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;


@Tag(name = "Authentication Endpoint.")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthServiceImpl service;

    @PostMapping(value = "/login")
    @Operation(summary = "Authenticates a user and returns a token")
    public ResponseEntity login(@RequestBody LoginRequest data){
        if(checkParamIsNotNull(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid request!");
        var token = service.login(data);
        if(token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid request!");
        return token;
    }



    private boolean checkParamIsNotNull(LoginRequest data){
        return  data == null || data.userName() ==null || data.userName().isBlank()
                || data.password() ==null || data.password().isBlank();
    }
}
