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
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String name;
    private Double price;
    private String category;
    private boolean disponible;
    private int stock;

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @Builder
    public Product(String name, Double price, String category, boolean disponible, int stock) {
        this.ref = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.category = category;
        this.disponible = disponible;
        this.stock = stock;
    }
}