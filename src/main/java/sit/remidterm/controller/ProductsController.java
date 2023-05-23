package sit.remidterm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.remidterm.dto.ProductCreateDTO;
import sit.remidterm.dto.ProductDTO;
import sit.remidterm.model.Products;
import sit.remidterm.service.ProductsService;
import sit.remidterm.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
//    public List<Products> getProducts() {
//        return productsService.getProducts();
//    }
    public List<ProductDTO> getProducts() {
        return listMapper.mapList(productsService.getProducts(), ProductDTO.class, modelMapper);
    }

    @GetMapping("/{id}")
//    public Products getProducts(@PathVariable String id) {
//        return productsService.getProducts(id);
//    }
    public ProductDTO getProducts(@PathVariable String id) {
        return modelMapper.map(productsService.getProducts(id), ProductDTO.class);
    }

    @PostMapping("")
//    public Products addProducts(@RequestBody ProductCreateDTO products) {
//        return productsService.addProducts(products);
//    }
    public ProductDTO addProducts(@RequestBody ProductCreateDTO products) {
        return modelMapper.map(productsService.addProducts(products), ProductDTO.class);
    }

    @PutMapping("/{id}")
//    public Products updateProducts(@RequestBody Products products, @PathVariable String id) {
//        return productsService.updateProducts(products, id);
// }
    public ProductDTO updateProducts(@RequestBody ProductCreateDTO products, @PathVariable String id) {
        return modelMapper.map(productsService.updateProducts(products, id), ProductDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable String id) {
        productsService.deleteProducts(id);
    }

}
