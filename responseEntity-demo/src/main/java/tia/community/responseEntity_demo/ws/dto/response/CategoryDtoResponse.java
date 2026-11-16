package tia.community.responseEntity_demo.ws.dto.response;

import lombok.*;
import tia.community.responseEntity_demo.entity.Product;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDtoResponse {
    private String ref;
    private String name;
    private String description;
    private String imageUrl;
}
