package tia.community.responseEntity_demo.service.facade;

import tia.community.responseEntity_demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findByRef(String ref);

    Product save(Product product, String refCategory);

    Product update(Product produit);

    void delete(Product produit);

    List<Product> findByCategoryId(String id);
}
