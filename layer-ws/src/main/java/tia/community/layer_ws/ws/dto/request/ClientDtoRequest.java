package tia.community.layer_ws.ws.dto.request;
import lombok.*;

/**
 * @author Ezzaim Mohammed
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDtoRequest {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String ville;
    private boolean actif;
}