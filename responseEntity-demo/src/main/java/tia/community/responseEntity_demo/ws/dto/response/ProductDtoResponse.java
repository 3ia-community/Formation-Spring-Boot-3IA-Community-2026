package tia.community.responseEntity_demo.ws.dto.response;

import lombok.*;
import tia.community.responseEntity_demo.entity.Category;

import java.time.LocalDate;

/**
 * @author Ezzaim Mohammed
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDtoResponse {
    private String ref;
    private String name;
    private Double price;
    private boolean disponible;
    private int stock;
    private String imageUrl;
    private CategoryDtoResponse category;
    private LocalDate dateCreation;
}

