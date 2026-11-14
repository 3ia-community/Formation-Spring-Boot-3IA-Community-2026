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
public class LigneCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ref;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Command command;

    private Integer quantite;

    private Double prix;
}