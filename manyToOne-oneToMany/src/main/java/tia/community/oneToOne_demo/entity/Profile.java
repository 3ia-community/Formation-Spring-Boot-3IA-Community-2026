package tia.community.oneToOne_demo.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Ezzaim Mohammed
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String ref;
    private String phone;
    private String avatarUrl;
    private String bio;
    private String adresse;
    private String ville;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "client_id"
    )
    private Client client;
}