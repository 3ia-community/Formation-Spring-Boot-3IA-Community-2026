package tia.community.oneToOne_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ref;
    private String name;
    private String description;
    private String imageUrl;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    public List<Produit> produits;

}
