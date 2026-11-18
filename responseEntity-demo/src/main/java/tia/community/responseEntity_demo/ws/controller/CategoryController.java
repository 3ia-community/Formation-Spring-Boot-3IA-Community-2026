package tia.community.responseEntity_demo.ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tia.community.responseEntity_demo.entity.Category;
import tia.community.responseEntity_demo.service.facade.CategoryService;
import tia.community.responseEntity_demo.ws.converter.CategoryConverter;
import tia.community.responseEntity_demo.ws.dto.request.CategoryDtoRequest;
import tia.community.responseEntity_demo.ws.dto.response.CategoryDtoResponse;

import java.net.URI;
import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    @GetMapping
    public ResponseEntity<List<CategoryDtoResponse>> findAll() {
        return ResponseEntity.ok().body(categoryConverter.toDtos(categoryService.findAll()));
    }

    @GetMapping("{ref}")
    public ResponseEntity<CategoryDtoResponse> findById(@PathVariable String ref) {
        return ResponseEntity.ok().body(categoryConverter.toDto(categoryService.findByRef(ref)));
    }

    @PostMapping
    public ResponseEntity<CategoryDtoResponse> save(@RequestBody CategoryDtoRequest dto) {
        Category category = categoryService.save(categoryConverter.toEntity(dto));
        URI uri = URI.create("/shop-app/categories/"+category.getRef());
        return ResponseEntity.created(uri).body(categoryConverter.toDto(category));
    }

    @PutMapping
    public ResponseEntity<CategoryDtoResponse> update(CategoryDtoRequest dto) {
        return ResponseEntity.ok().body(categoryConverter.toDto(categoryService.update(categoryConverter.toEntity(dto))));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(CategoryDtoRequest dto) {
        categoryService.delete(categoryConverter.toEntity(dto));
        return ResponseEntity.noContent().build();
    }
}
