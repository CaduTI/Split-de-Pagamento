package br.com.sps.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "permission")
@Builder
@Data
public class Permission implements GrantedAuthority,Serializable {
    private static final Long serialVersionUID = 1l;
    @Id
    @GeneratedValue()
    private Long id;
    @Column()
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}

