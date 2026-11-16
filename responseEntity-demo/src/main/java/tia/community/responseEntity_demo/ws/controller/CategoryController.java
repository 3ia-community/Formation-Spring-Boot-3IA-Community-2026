package tia.community.responseEntity_demo.ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tia.community.responseEntity_demo.entity.Category;
import tia.community.responseEntity_demo.service.facade.CategoryService;
import tia.community.responseEntity_demo.ws.converter.CategoryConverter;
import tia.community.responseEntity_demo.ws.dto.request.CategoryDtoRequest;
import tia.community.responseEntity_demo.ws.dto.response.CategoryDtoResponse;

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
    public List<CategoryDtoResponse> findAll() {
        return categoryConverter.toDtos(categoryService.findAll());
    }

    @GetMapping("{id}")
    public CategoryDtoResponse findById(@PathVariable String ref) {
        return categoryConverter.toDto(categoryService.findByRef(ref));
    }

    @PostMapping
    public CategoryDtoResponse save(@RequestBody CategoryDtoRequest dto) {
        return categoryConverter.toDto(categoryService.save(categoryConverter.toEntity(dto)));
    }

    @PutMapping
    public CategoryDtoResponse update(CategoryDtoRequest dto) {
        return categoryConverter.toDto(categoryService.update(categoryConverter.toEntity(dto)));
    }

    @DeleteMapping
    public void delete(CategoryDtoRequest dto) {
        categoryService.delete(categoryConverter.toEntity(dto));
    }
}
