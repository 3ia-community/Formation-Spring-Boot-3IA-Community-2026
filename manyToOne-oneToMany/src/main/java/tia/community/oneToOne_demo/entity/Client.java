package tia.community.oneToOne_demo.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Ezzaim Mohammed
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String ref;
    private String username;
    private String lastname;
    private String email;
    private String password;

    @OneToOne(mappedBy = "client", cascade = CascadeType.REMOVE)
    private Profile profile;
}