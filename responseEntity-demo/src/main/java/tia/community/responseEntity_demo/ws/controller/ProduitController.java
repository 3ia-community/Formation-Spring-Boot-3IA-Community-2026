package tia.community.responseEntity_demo.ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tia.community.responseEntity_demo.entity.Product;
import tia.community.responseEntity_demo.service.facade.ProductService;
import tia.community.responseEntity_demo.ws.converter.ProduitConverter;
import tia.community.responseEntity_demo.ws.dto.request.ProductDtoRequest;
import tia.community.responseEntity_demo.ws.dto.response.ProductDtoResponse;

import java.net.URI;
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
    public ResponseEntity<List<ProductDtoResponse>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Response-Status", "Success")
                .body(produitConverter.toDtos(produitService.findAll()));
    }

    @GetMapping("{ref}")
    public ResponseEntity<ProductDtoResponse> findByRef(@PathVariable String ref) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produitConverter.toDto(produitService.findByRef(ref)));
    }

    @PostMapping
    public ResponseEntity<ProductDtoResponse> save(@RequestBody ProductDtoRequest dto) {
        Product product = produitService.save(produitConverter.toEntity(dto), dto.getRefCategory());
        URI uri = URI.create("/shop-app/produits/"+product.getRef());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(uri)
                .body(produitConverter.toDto(product));
    }

    @PutMapping
    public ResponseEntity<ProductDtoResponse> update(@RequestBody ProductDtoRequest dto) {
        Product product = produitService.update(produitConverter.toEntity(dto));
        return ResponseEntity.ok().body(produitConverter.toDto(product));
    }

    @DeleteMapping("{ref}")
    public ResponseEntity<Void> delete(@PathVariable String ref) {
        produitService.delete(ref);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("category/{ref}")
    public ResponseEntity<List<ProductDtoResponse>> findByCategoryRef(@PathVariable String ref) {
        return ResponseEntity.ok().body(produitConverter.toDtos(produitService.findByCategoryRef(ref)));
    }
}
