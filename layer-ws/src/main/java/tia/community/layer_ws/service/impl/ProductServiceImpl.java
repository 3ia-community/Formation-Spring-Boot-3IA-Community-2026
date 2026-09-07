package tia.community.layer_ws.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tia.community.layer_ws.entity.Product;
import tia.community.layer_ws.repository.ProductRepository;
import tia.community.layer_ws.service.facade.ProductService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @Override
    public Product save(Product product) {
        product.setRef(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        products.forEach(product -> {
            product.setRef(UUID.randomUUID().toString());
        });
        return productRepository.saveAll(products);
    }

    @Override
    public int update(String refCurrentProduct, Product nvProduct) {
        if (refCurrentProduct == null || refCurrentProduct.isBlank() || nvProduct == null) {
            return -1;
        } else {
            Product productInDB = productRepository.findByRef(refCurrentProduct);

            if (productInDB == null) return -2;
            else {

                productInDB.setName(nvProduct.getName());
                productInDB.setPrice(nvProduct.getPrice());
                productInDB.setCategory(nvProduct.getCategory());
                productInDB.setDisponible(nvProduct.isDisponible());
                productInDB.setStock(nvProduct.getStock());

                productRepository.save(productInDB);
                return 1;
            }
        }
    }

    @Override
    public int updatePartial(String refCurrentProduct, Map<String, Object> updates) {
        if (refCurrentProduct == null || refCurrentProduct.isBlank() || updates == null) {
            return -1;
        }
        else {
            Product productInDB = productRepository.findByRef(refCurrentProduct);

            if (productInDB == null) return -2;
            else {
                if (updates.containsKey("name")) {
                    productInDB.setName(updates.get("name").toString());
                }
                if (updates.containsKey("price")) {
                    productInDB.setPrice(Double.valueOf(updates.get("price").toString()));
                }

                if (updates.containsKey("category")) {
                    productInDB.setCategory(updates.get("category").toString());
                }
                if (updates.containsKey("disponible")) {
                    productInDB.setDisponible(Boolean.parseBoolean(updates.get("disponible").toString()));
                }
                if (updates.containsKey("stock")) {
                    productInDB.setStock(Integer.parseInt(updates.get("stock").toString()));
                }

                productRepository.save(productInDB);
                return 1;
            }
        }
    }
}