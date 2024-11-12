package br.com.sps.controller;

import br.com.sps.dtos.CreateUserDTO;
import br.com.sps.model.User;
import br.com.sps.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UserController {
    @Autowired
    UserServiceImpl service;
    @PostMapping(value = "/register")
    @Operation(summary = "Authenticates a user and returns a token")
    public ResponseEntity<Void> createuser(@RequestBody CreateUserDTO dto){
        service.createuser(dto);
        return ResponseEntity.ok().build();
    }
}
