package in.parthi.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.core.model.Product;
import in.parthi.core.repository.ProductRepo;

public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    ProductRepo productRepo = new ProductRepo();

    public String addProduct(Product product) {
        String response = "";
        try {
            response = productRepo.addProduct(product);
        } catch (RuntimeException e) {
            response = e.getLocalizedMessage();
        }
        return response;
    }
}
