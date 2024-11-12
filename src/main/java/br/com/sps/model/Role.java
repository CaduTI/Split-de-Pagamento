package br.com.sps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "Role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role implements Serializable {
    private static final Long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column()
    private String description;

    public enum Values {

        Admin(1l),
        Acquirer(2L),
        Master(3L),
        Subordinate(4L);

        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }
    }
}


