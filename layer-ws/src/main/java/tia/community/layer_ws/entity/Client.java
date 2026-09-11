package tia.community.layer_ws.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Ezzaim Mohammed
 */

@Entity
@Table(name = "clients")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ref;

    private String nom;
    private String prenom;
    private String email;
    private String ville;
    private boolean actif;

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @PrePersist
    public void prePersist() {
        if (this.ref == null) {
            this.ref = UUID.randomUUID().toString();
        }
    }
}