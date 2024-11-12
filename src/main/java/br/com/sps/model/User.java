package br.com.sps.model;

import br.com.sps.dtos.request.LoginRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private static final Long serialVersionUID = 1l;
    @Id
    @GeneratedValue()
    private Long id;
    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_user")},
            inverseJoinColumns = {@JoinColumn (name = "id_permission")}
    )

    public Set<Role> getRoles() {
        return roles;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }
}
