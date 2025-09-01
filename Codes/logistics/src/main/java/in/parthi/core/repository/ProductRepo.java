package in.parthi.core.repository;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.core.model.Product;

public class ProductRepo {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepo.class);
    List<Product> productList = new ArrayList<>();

    /**
     * This method take a an procuct id and retrieve the product from the database.
     * 
     * @param String id with which the product needs to be found
     * @return Returns the product
     * @throws RuntimeException if the product is unavailable in the database.
     */
    public Product getProduct(String id) throws RuntimeException {// Create a NotFound Exception
        Product product = null;
        for (Product tmpProduct : productList) {
            if (tmpProduct.getId().equalsIgnoreCase(id)) {
                product = tmpProduct;
                logger.info("Product with id: " + id + " found in database");
            }

        }

        if (product == null) {
            logger.warn("Product with id: " + id + " not found in database");
            throw new RuntimeException("The product with id " + id + " Not Found");
        }

        return product;

    }

    /**
     * This method take a product details and add it to the database.
     * 
     * @param Product that need to be added to the database
     * @return Returns the choice of the user
     * @throws RuntimeException if the product is already available in the database.
     */
    public String addProduct(Product product) throws RuntimeException {// Create a NotFound Exception
        String response = "";
        boolean hasProduct = false;
        for (Product tmpProduct : productList) {
            if (tmpProduct.getId().equalsIgnoreCase(product.getId())) {
                hasProduct = true;
                break;
            }

        }
        if (hasProduct) {
            logger.warn("Product with id: " + product.getId() + " already available in database");
            throw new RuntimeException("The product with id " + product.getId() + " Already present in database, Unable to create the product");
        }

        productList.add(product);
        response = "Product added successfully";
        logger.info("Product with id: " + product.getId() + " added to the database");
        return response;
    }
}
