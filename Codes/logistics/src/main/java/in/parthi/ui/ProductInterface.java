package in.parthi.ui;

import java.time.LocalDate;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.common.Properties;
import in.parthi.core.model.Product;
import in.parthi.core.service.ProductService;

public class ProductInterface {

    private static final Logger logger = LoggerFactory.getLogger(ProductInterface.class);
    
    ProductService productService = new ProductService();

    /**
     * This method take a product id and call repo class to retrieve the corresponding product.
     * 
     * @return Returns a Product matching with product ID
     */
    public Product getProduct() {

        Product product =  null;
        Scanner sc = new Scanner(System.in);
        logger.info("Start taking product details from user");
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();
        product = productService.getProduct(id);
        return product;
    }

    /**
     * This method take a product details and call repo class to add the product.
     * 
     * @return Returns a responce message for the addition action of product
     */
    public String addProduct() {
        String response = "";
        Scanner sc = new Scanner(System.in);
        logger.info("Start taking product details from user");
        Product product = new Product();
        try {
            // Take Stocking date from user
            LocalDate today = LocalDate.now();
            System.out.print("Enter Stockin Date e.g 2025-09-23 (default: " + today.toString() + "): ");
            String strDate = sc.nextLine();
            if (strDate.length() == 0) {
                product.setStockInDate(today);
            } else {
                product.setStockInDate(LocalDate.parse(strDate));
            }

            //
            product.setStatus("AVAILABLE");

            //
            System.out.print("Enter Product ID: ");
            product.setId(sc.nextLine());

            //
            System.out.print("Enter Product Category: ");
            product.setCategory(sc.nextLine());

            //
            System.out.print("Enter Product Name: ");
            product.setName(sc.nextLine());

            System.out.print("Enter Product Description: ");
            product.setDescription(sc.nextLine());

            System.out.print("Enter Product Cost: ");
            product.setCostPrice(sc.nextDouble());

            System.out.print("Enter Product mrp: ");
            product.setMrp(sc.nextDouble());

            response = productService.addProduct(product);
            
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            for(StackTraceElement str : e.getStackTrace()){
                System.out.println(str.toString());
            }
            response = e.getLocalizedMessage();
        } 
        return response;
    }
}
