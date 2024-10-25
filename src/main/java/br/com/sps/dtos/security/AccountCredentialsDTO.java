package br.com.sps.dtos.security;

public record AccountCredentialsDTO(
        String userName,
        String password
) {
}
