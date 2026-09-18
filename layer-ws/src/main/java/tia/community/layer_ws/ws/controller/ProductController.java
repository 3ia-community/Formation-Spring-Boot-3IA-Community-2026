package tia.community.layer_ws.ws.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tia.community.layer_ws.entity.Product;
import tia.community.layer_ws.service.facade.ProductService;

import java.util.List;
import java.util.Map;

/**
 * @author Ezzaim Mohammed
 */
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(Sort sort) {
        return productService.findAll(sort);
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.GET)
    public Product findByRef(@PathVariable String ref) {
        return productService.findByRef(ref);
    }

    @RequestMapping(path = "category/{category}", method = RequestMethod.GET)
    public List<Product> findByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }


    @RequestMapping(path = "category/{category}/isDisbonible/{isDisbonible}", method = RequestMethod.GET)
    public List<Product> findByCategoryAndDisbonible(@PathVariable String category, @PathVariable(name = "isDisbonible") boolean disbonible) {
        return productService.findByCategoryAndDisbonible(category, disbonible);
    }

    @GetMapping("search")
    @RequestMapping(path = "search", method = RequestMethod.GET)
    public List<Product> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Boolean disbonible
    ){
        return productService.search(name, category, minPrice, disbonible);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(path = "saveAll", method = RequestMethod.POST)
    public List<Product> saveAll(@RequestBody List<Product> products) {
        return productService.saveAll(products);
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.PUT)
    public int update(@PathVariable("ref") String refCurrentProduct, @RequestBody Product nvProduct) {
        return productService.update(refCurrentProduct, nvProduct);
    }

    @RequestMapping(path = "{ref}", method = RequestMethod.PATCH)
    public int updatePartial(@PathVariable("ref") String refCurrentProduct, @RequestBody Map<String, Object> updates) {
        return productService.updatePartial(refCurrentProduct, updates);
    }


    @RequestMapping(path = "{ref}", method = RequestMethod.DELETE)
    public int delete(@PathVariable(name = "ref") String refCurrentProduct) {
        return productService.delete(refCurrentProduct);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteByRefs(@RequestBody List<String> refs) {
        productService.deleteByRefs(refs);
    }

    @RequestMapping(path = "category/{category}", method = RequestMethod.DELETE)
    public void deleteByCategory(@PathVariable String category) {
        productService.deleteByCategory(category);
    }

}