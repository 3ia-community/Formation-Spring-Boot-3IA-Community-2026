package tia.community.layer_ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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

}