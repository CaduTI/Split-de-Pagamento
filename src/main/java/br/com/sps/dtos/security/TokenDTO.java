package br.com.sps.dtos.security;

import javax.xml.crypto.Data;
import java.util.Date;

public record TokenDTO(
        String userName,
        Boolean authenticated,
        Date createdAt,
        Date expiration,
        String acessToken,
        String refreshToken
) {}
