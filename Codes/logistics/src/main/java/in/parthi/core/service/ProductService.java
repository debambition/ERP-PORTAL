package in.parthi.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.core.model.product.AddProduct;
import in.parthi.core.model.product.Product;
import in.parthi.core.repository.ProductRepo;

public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    ProductRepo productRepo = new ProductRepo();
    TransactionService transactionService = new TransactionService();

    /**
     * This method take a an procuct id and retrieve the product from the database.
     * 
     * @param String id with which the product needs to be found
     * @return Returns the product
     * @throws RuntimeException if the product is unavailable in the database.
     */
    public Product getProduct(String id) {
        Product response = null;
        try {
            response = productRepo.getProduct(id);
        } catch (RuntimeException e) {
            logger.error("Exception occured while adding product: " + e.getLocalizedMessage());
        }
        return response;
    }

    /**
     * This method take a product details and add it to the database.
     * 
     * @param Product that need to be added to the database
     * @return Returns the choice of the user
     */
    public String addProduct(Product product) {
        String response = "";
        try {
            response = productRepo.addProduct(product);
        } catch (RuntimeException e) {
            response = e.getLocalizedMessage();
            logger.error("Exception occured while adding product: " + e.getLocalizedMessage());
        }
        return response;
    }

    /**
     * This method take a product details and add it to the database.
     * 
     * @param Product that need to be added to the database
     * @return Returns the choice of the user
     */
    public String addProduct(AddProduct addProduct) {
        String response = "";
        try {
            response = transactionService.addTransaction(addProduct.getTransaction());
            if (response.contains("added successfully")){
                for(Product product: addProduct.getProduct()){
                    response = productRepo.addProduct(product);
                }
                
            }
            
        } catch (RuntimeException e) {
            response = e.getLocalizedMessage();
            logger.error("Exception occured while adding product: " + e.getLocalizedMessage());
        }
        return response;
    }

     /**
     * This method take a product details and  remove product from the database.
     * 
     * @param Product that need to be delete to the database
     * @return Returns the responce
     */
    public String returnToVendor(String id){
        //String response = "";
        String response = null;
        try{
           
           response = productRepo.returnToVendor(id);
        }
        catch (RuntimeException e){
                  
            response = e.getLocalizedMessage();
        }

        return response;
        

    }
}
