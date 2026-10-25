package tia.community.oneToOne_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
}