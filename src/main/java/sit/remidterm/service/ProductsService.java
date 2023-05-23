package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.remidterm.dto.ProductCreateDTO;
import sit.remidterm.model.Productlines;
import sit.remidterm.model.Products;
import sit.remidterm.repository.ProductlinesRepository;
import sit.remidterm.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductlinesRepository productlinesRepository;

    public List<Products> getProducts() {
        return productsRepository.findAll();
    }

    public Products getProducts(String productCode) {
        return productsRepository.findById(productCode).orElseThrow();
    }

    public Products addProducts(ProductCreateDTO products) {
        Products products1 = new Products();
        return getProducts(products, products1);
    }

    public Products getProducts(ProductCreateDTO productCreateDTO, Products products) {
        if (productCreateDTO.getProductCode() != null) {
            products.setProductCode(productCreateDTO.getProductCode());
        }
        if (productCreateDTO.getProductName() != null) {
            products.setProductName(productCreateDTO.getProductName());
        }
        if (productCreateDTO.getProductLine() != null) {
            Productlines productlines = productlinesRepository.findById(productCreateDTO.getProductLine()).orElseThrow();
            products.setProductLine(productlines);
        }
        if (productCreateDTO.getProductScale() != null) {
            products.setProductScale(productCreateDTO.getProductScale());
        }
        if (productCreateDTO.getProductVendor() != null) {
            products.setProductVendor(productCreateDTO.getProductVendor());
        }
        if (productCreateDTO.getProductDescription() != null) {
            products.setProductDescription(productCreateDTO.getProductDescription());
        }
        if (productCreateDTO.getQuantityInStock() != null) {
            products.setQuantityInStock(productCreateDTO.getQuantityInStock());
        }
        if (productCreateDTO.getBuyPrice() != null) {
            products.setBuyPrice(productCreateDTO.getBuyPrice());
        }
        if (productCreateDTO.getRetailPrice() != null) {
            products.setRetailPrice(productCreateDTO.getRetailPrice());
        }
        return productsRepository.saveAndFlush(products);
    }

    public void deleteProducts(String id) {
        productsRepository.deleteById(id);
    }

    public Products updateProducts(ProductCreateDTO products, String id) {
        Products products1 = productsRepository.findById(id).orElseThrow();
        return getProducts(products, products1);
    }
}
