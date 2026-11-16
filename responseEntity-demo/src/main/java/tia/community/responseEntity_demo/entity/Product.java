package tia.community.responseEntity_demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Ezzaim Mohammed
 */
@Entity
@NoArgsConstructor  @AllArgsConstructor
@Getter @Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ref;

    private String name;
    private Double price;
    private boolean disponible;
    private int stock;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @CreationTimestamp
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @PrePersist
    public void prePersist() {
        if (this.ref == null) {
            this.ref = UUID.randomUUID().toString();
        }
    }
}
