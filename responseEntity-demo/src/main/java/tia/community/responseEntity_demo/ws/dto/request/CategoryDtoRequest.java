package tia.community.responseEntity_demo.ws.dto.request;

import lombok.*;

/**
 * @author Ezzaim Mohammed
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDtoRequest {
    private String name;
    private String description;
    private String imageUrl;
}
