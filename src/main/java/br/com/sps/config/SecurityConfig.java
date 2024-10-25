package br.com.sps.config;

import br.com.sps.security.jwt.JwtConfigurer;
import br.com.sps.security.jwt.JwtTokenProvider;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig  {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder(
                "",               // secret (opcional, pode ser uma string vazia)
                185000,           // iteration count (recomendado >= 185000)
                256,              // hash width (tamanho do hash gerado, 256 bits)
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256 // Algoritmo (recomendado PBKDF2WithHmacSHA256)
        ));
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder("",
                185000,
                256,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256 ));
        return passwordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita autenticação básica via HTTP
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/api/v1/**").authenticated()
                        .requestMatchers("/users").denyAll()
                )
                // Configuração de CSRF (desabilitado)
                .csrf(csrf -> csrf.disable())
                // Configuração da política de sessão (stateless)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Configura o CORS
                .cors(cors -> cors.configure(http))
                // Adiciona o filtro de JWT (autenticação por token)
                .addFilterBefore((Filter) new JwtConfigurer(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
