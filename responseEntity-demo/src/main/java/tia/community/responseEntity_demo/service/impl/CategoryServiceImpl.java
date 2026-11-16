package tia.community.responseEntity_demo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tia.community.responseEntity_demo.dao.CategoryDao;
import tia.community.responseEntity_demo.entity.Category;
import tia.community.responseEntity_demo.service.facade.CategoryService;

import java.util.List;
import java.util.UUID;

/**
 * @author Ezzaim Mohammed
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findByRef(String ref) {
        return categoryDao.findByRef(ref);
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
