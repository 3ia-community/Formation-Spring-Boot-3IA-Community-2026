package tia.community.oneToOne_demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ref;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(
            mappedBy = "command",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LigneCommand> ligneCommands = new ArrayList<>();

    @CreationTimestamp
    private LocalDate dateCommand;

    private Boolean status;

    private Double prixTotal;
}