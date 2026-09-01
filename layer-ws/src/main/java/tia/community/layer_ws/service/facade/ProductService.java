package tia.community.layer_ws.service.facade;

import org.springframework.data.domain.Sort;
import tia.community.layer_ws.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(Sort sort);

    Product findByRef(String ref);

    List<Product> findByCategory(String category);

    List<Product> findByCategoryAndDisbonible(String category, boolean disbonible);

    List<Product> search(String name, String category, Double minPrice, Boolean disbonible);
}
