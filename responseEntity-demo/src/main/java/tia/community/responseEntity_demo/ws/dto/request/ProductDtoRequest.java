package tia.community.responseEntity_demo.ws.dto.request;

import lombok.*;
import tia.community.responseEntity_demo.entity.Category;

/**
 * @author Ezzaim Mohammed
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDtoRequest {
    private String name;
    private Double price;
    private boolean disponible;
    private int stock;
    private String imageUrl;
    private String refCategory;
}

