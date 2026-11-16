package tia.community.responseEntity_demo.ws.converter;

import org.springframework.stereotype.Component;
import tia.community.responseEntity_demo.entity.Category;
import tia.community.responseEntity_demo.ws.dto.request.CategoryDtoRequest;
import tia.community.responseEntity_demo.ws.dto.response.CategoryDtoResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Component
public class CategoryConverter {
    public Category toEntity(CategoryDtoRequest dto) {
        if (dto == null) return null;
        Category entity = Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .imageUrl(dto.getImageUrl())
                .build();
        return entity;
    }

    public CategoryDtoResponse toDto(Category entity) {
        if (entity == null) return null;
        CategoryDtoResponse dto = CategoryDtoResponse.builder()
                .ref(entity.getRef())
                .name(entity.getName())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .build();
        return dto;
    }

    public List<Category> toEntities(List<CategoryDtoRequest> dtos) {
        if (dtos == null) return null;
        List<Category> entities = new ArrayList<>();
        for (CategoryDtoRequest dto: dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    public List<CategoryDtoResponse> toDtos(List<Category> entities) {
        if (entities == null) return null;
        List<CategoryDtoResponse> dtos = new ArrayList<>();
        for (Category entity: entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
