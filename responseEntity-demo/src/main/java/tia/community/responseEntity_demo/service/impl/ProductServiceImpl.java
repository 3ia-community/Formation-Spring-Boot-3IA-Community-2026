package tia.community.responseEntity_demo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tia.community.responseEntity_demo.dao.CategoryDao;
import tia.community.responseEntity_demo.dao.ProductDao;
import tia.community.responseEntity_demo.entity.Category;
import tia.community.responseEntity_demo.entity.Product;
import tia.community.responseEntity_demo.service.facade.ProductService;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findByRef(String ref) {
        return productDao.findByRef(ref);
    }

    @Override
    public Product save(Product product, String refCategory) {
        Category category = categoryDao.findByRef(refCategory);

        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        product.setCategory(category);
        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.save(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public List<Product> findByCategoryRef(String ref) {
        return productDao.findByCategoryRef(ref);
    }
}

