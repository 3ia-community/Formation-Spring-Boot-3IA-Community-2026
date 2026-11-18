package tia.community.responseEntity_demo.service.facade;

import tia.community.responseEntity_demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findByRef(String ref);

    Product save(Product product, String refCategory);

    Product update(Product produit);

    void delete(String ref);

    List<Product> findByCategoryRef(String id);
}
