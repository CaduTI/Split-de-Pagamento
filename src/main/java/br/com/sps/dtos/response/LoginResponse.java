package br.com.sps.dtos.response;

public record LoginResponse(String acessToken, long expireIn ) {
}
