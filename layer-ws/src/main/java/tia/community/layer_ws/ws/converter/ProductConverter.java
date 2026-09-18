package tia.community.layer_ws.ws.converter;

import org.springframework.stereotype.Component;
import tia.community.layer_ws.entity.Product;
import tia.community.layer_ws.ws.dto.request.ProductDtoRequest;
import tia.community.layer_ws.ws.dto.response.ProductDtoResponse;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@Component
public class ProductConverter {
    public Product toEntity(ProductDtoRequest dto) {
        return null;
    }

    public ProductDtoResponse toDto(Product entity) {
        return null;
    }

    public List<Product> toEntities(List<ProductDtoRequest> dtos) {
        return null;
    }

    public List<ProductDtoResponse> toDtos(List<Product> entities) {
        return null;
    }
}