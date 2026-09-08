package tia.community.layer_ws.service.facade;

import org.springframework.data.domain.Sort;
import tia.community.layer_ws.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll(Sort sort);

    Product findByRef(String ref);

    List<Product> findByCategory(String category);

    List<Product> findByCategoryAndDisbonible(String category, boolean disbonible);

    List<Product> search(String name, String category, Double minPrice, Boolean disbonible);

    Product save(Product product);

    List<Product> saveAll(List<Product> products);

    int update(String refCurrentProduct, Product nvProduct);

    int updatePartial(String refCurrentProduct, Map<String, Object> updates);

    int delete(String refCurrentProduct);

    void deleteByRefs(List<String> refs);

    void deleteByCategory(String category);
}
