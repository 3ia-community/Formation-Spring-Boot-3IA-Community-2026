package tia.community.responseEntity_demo.service.facade;

import tia.community.responseEntity_demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findByRef(String ref);

    Category save(Category category);

    Category update(Category category);

    void delete(Category category);
}
