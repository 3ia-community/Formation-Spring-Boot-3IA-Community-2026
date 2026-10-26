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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ref;

    private String name;
    private Double price;
    private boolean disponible;
    private int stock;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
