package tia.community.responseEntity_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tia.community.responseEntity_demo.entity.Category;
import tia.community.responseEntity_demo.entity.Product;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, String> {
    Product findByRef(String ref);
    List<Product> findByCategoryRef(String ref);
}

