package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.remidterm.model.Productlines;
import sit.remidterm.repository.ProductlinesRepository;

import java.util.List;

@Service
public class ProductlinesService {
    @Autowired
    private ProductlinesRepository productlinesRepository;

    public List<Productlines> getProductlines() {
        return productlinesRepository.findAll();
    }

    public Productlines getProductlines(String productLine) {
        return productlinesRepository.findById(productLine).orElseThrow();
    }

    public Productlines addProductlines(Productlines productlines) {
        return productlinesRepository.saveAndFlush(productlines);
    }

    public Productlines updateProductlines(String productLine, Productlines productlines) {
        Productlines productlines2 = productlinesRepository.findById(productLine).orElseThrow();
        productlines2.setProductLine(productlines.getProductLine());
        productlines2.setTextDescription(productlines.getTextDescription());
        return productlinesRepository.saveAndFlush(productlines2);
    }

    public void deleteProductlines(String productLine) {
        productlinesRepository.deleteById(productLine);
    }
}
