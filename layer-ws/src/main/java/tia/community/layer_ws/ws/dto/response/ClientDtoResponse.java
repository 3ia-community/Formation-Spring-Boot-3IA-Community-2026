package tia.community.layer_ws.ws.dto.response;
import lombok.*;

/**
 * @author Ezzaim Mohammed
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDtoResponse {
    private String ref;
    private String nom;
    private String prenom;
    private String email;
    private String ville;
    private boolean actif;
}