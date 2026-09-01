package tia.community.layer_ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tia.community.layer_ws.entity.Product;
import tia.community.layer_ws.service.facade.ProductService;

import java.util.List;

/**
 * @author Ezzaim Mohammed
 */
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAll(Sort sort) {
        return productService.findAll(sort);
    }

    @GetMapping("{ref}")
    public Product findByRef(@PathVariable String ref) {
        return productService.findByRef(ref);
    }

    @GetMapping("category/{category}")
    public List<Product> findByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }

    @GetMapping("category/{category}/isDisbonible/{isDisbonible}")
    public List<Product> findByCategoryAndDisbonible(@PathVariable String category, @PathVariable(name = "isDisbonible") boolean disbonible) {
        return productService.findByCategoryAndDisbonible(category, disbonible);
    }

    @GetMapping("search")
    public List<Product> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Boolean disbonible
    ){
        return productService.search(name, category, minPrice, disbonible);
    }


//    @GetMapping("search")
//    public List<Product> search(
//            ProductFilter productFilter
//    ){
//        return productService.search(productFilter.getName(), productFilter.getCategory(), productFilter.getMinPrice(), productFilter.getDisbonible());
//    }
}

//@Getter @Setter
//class ProductFilter {
//    private String name;
//    private String category;
//    private Double minPrice;
//    private Boolean disbonible;
//}

