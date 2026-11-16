package tia.community.responseEntity_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Ezzaim Mohammed
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ref;

    private String name;
    private String description;
    private String imageUrl;

    @OneToMany(mappedBy = "category")
    public List<Product> produits;

    @PrePersist
    public void prePersist() {
        if (this.ref == null) {
            this.ref = UUID.randomUUID().toString();
        }
    }
}
