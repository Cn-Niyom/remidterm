package sit.remidterm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.model.Productlines;
import sit.remidterm.service.ProductlinesService;

import java.util.List;

@RestController
@RequestMapping("/api/productlines")
public class ProductlineController {
    @Autowired
    private ProductlinesService productlinesService;

    @GetMapping("")
    public List<Productlines> getProductlines() {
        return productlinesService.getProductlines();
    }

    @GetMapping("/{productLine}")
    public Productlines getProductlines(@PathVariable String productLine) {
        return productlinesService.getProductlines(productLine);
    }

    @PostMapping("")
    public Productlines addProductlines(Productlines productlines) {
        return productlinesService.addProductlines(productlines);
    }

    @PutMapping("/{productLine}")
    public Productlines updateProductlines(@PathVariable String productLine, Productlines productlines) {
        return productlinesService.updateProductlines(productLine, productlines);
    }

    @DeleteMapping("/{productLine}")
    public void deleteProductlines(@PathVariable String productLine) {
        productlinesService.deleteProductlines(productLine);
    }
}
