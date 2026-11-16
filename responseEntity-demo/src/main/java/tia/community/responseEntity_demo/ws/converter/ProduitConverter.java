package tia.community.responseEntity_demo.ws.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tia.community.responseEntity_demo.entity.Product;
import tia.community.responseEntity_demo.ws.dto.request.ProductDtoRequest;
import tia.community.responseEntity_demo.ws.dto.response.ProductDtoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Component
@AllArgsConstructor
public class ProduitConverter {
    private final CategoryConverter categoryConverter;
    public Product toEntity(ProductDtoRequest dto) {
        if (dto == null) {
            return null;
        }
        else {
            Product entity = new Product();
            entity.setName(dto.getName());
            entity.setPrice(dto.getPrice());
            entity.setDisponible(dto.isDisponible());
            entity.setStock(dto.getStock());
            entity.setImageUrl(dto.getImageUrl());
            entity.setCategory(null);

            return entity;
        }
    }

    public ProductDtoResponse toDto(Product entity) {
        if (entity == null) return null;
        ProductDtoResponse dto = ProductDtoResponse.builder()
                .ref(entity.getRef())
                .name(entity.getName())
                .price(entity.getPrice())
                .disponible(entity.isDisponible())
                .stock(entity.getStock())
                .imageUrl(entity.getImageUrl())
                .dateCreation(entity.getDateCreation())
                .category(categoryConverter.toDto(entity.getCategory()))
                .build();

        return dto;
    }

    public List<Product> toEntities(List<ProductDtoRequest> dtos) {
        if (dtos == null) return null;
        List<Product> entities = new ArrayList<>();
        for (ProductDtoRequest dto: dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    public List<ProductDtoResponse> toDtos(List<Product> entities) {
        if (entities == null) return null;
        List<ProductDtoResponse> dtos = new ArrayList<>();
        for (Product entity: entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}