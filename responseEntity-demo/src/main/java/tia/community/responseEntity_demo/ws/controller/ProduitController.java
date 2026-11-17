package tia.community.responseEntity_demo.ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tia.community.responseEntity_demo.entity.Product;
import tia.community.responseEntity_demo.service.facade.ProductService;
import tia.community.responseEntity_demo.ws.converter.ProduitConverter;
import tia.community.responseEntity_demo.ws.dto.request.ProductDtoRequest;
import tia.community.responseEntity_demo.ws.dto.response.ProductDtoResponse;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@RestController
@AllArgsConstructor
@RequestMapping("produits")
public class ProduitController {
    private final ProductService produitService;
    private final ProduitConverter produitConverter;

    @GetMapping
    public List<ProductDtoResponse> findAll() {
        return produitConverter.toDtos(produitService.findAll());
    }

    @GetMapping("{id}")
    public ProductDtoResponse findByRef(@PathVariable String ref) {
        return produitConverter.toDto(produitService.findByRef(ref));
    }

    @PostMapping
    public ProductDtoResponse save(@RequestBody ProductDtoRequest dto) {
        return produitConverter.toDto(produitService.save(produitConverter.toEntity(dto), dto.getRefCategory()));
    }

    @PutMapping
    public ProductDtoResponse update(@RequestBody ProductDtoRequest dto) {
        return produitConverter.toDto(produitService.update(produitConverter.toEntity(dto)));
    }

    @DeleteMapping
    public void delete(@RequestBody ProductDtoRequest dto) {
        produitService.delete(produitConverter.toEntity(dto));
    }

    @GetMapping("category/{ref}")
    public List<ProductDtoResponse> findByCategoryRef(@PathVariable String ref) {
        return produitConverter.toDtos(produitService.findByCategoryRef(ref));
    }
}
