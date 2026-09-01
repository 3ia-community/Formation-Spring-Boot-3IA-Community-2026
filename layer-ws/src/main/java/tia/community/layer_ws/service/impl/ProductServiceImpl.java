package tia.community.layer_ws.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tia.community.layer_ws.entity.Product;
import tia.community.layer_ws.repository.ProductRepository;
import tia.community.layer_ws.service.facade.ProductService;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    @Override
    public Product findByRef(String ref) {
        return productRepository.findByRef(ref);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByCategoryAndDisbonible(String category, boolean disbonible) {
        return productRepository.findByCategoryAndDisponible(category, disbonible);
    }

    @Override
    public List<Product> search(String name, String category, Double minPrice, Boolean disbonible) {
        return productRepository.search(name, category, minPrice, disbonible);
    }
}