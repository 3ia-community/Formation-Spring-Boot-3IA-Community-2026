package tia.community.layer_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tia.community.layer_ws.entity.Product;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByRef(String ref);
    List<Product> findByCategory(String category);
    List<Product> findByCategoryAndDisponible(String category, boolean disponible);

    @Query(
            """
            SELECT p FROM Product p WHERE (:name IS NULL OR p.name =:name) AND (:category IS NULL OR p.category =:category) AND
            (:minPrice IS NULL OR p.price <= :minPrice) AND (:disbonible IS NULL OR p.disponible =:disbonible)
"""
    )
    List<Product> search(String name, String category, Double minPrice, Boolean disbonible);
}