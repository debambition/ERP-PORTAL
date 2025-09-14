package in.parthi.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.common.Properties;
import in.parthi.core.model.product.AddProduct;
import in.parthi.core.model.product.Product;
import in.parthi.core.model.transaction.Transaction;
import in.parthi.core.service.ProductService;
import in.parthi.core.service.TransactionService;


public class ProductInterface {

    private static final Logger logger = LoggerFactory.getLogger(ProductInterface.class);

    ProductService productService = new ProductService();
    TransactionInterface transactionInterface = new TransactionInterface();
    TransactionService transactionService = new TransactionService();

    /**
     * This method take a product id and call repo class to retrieve the corresponding product.
     * 
     * @return Returns a Product matching with product ID
     */
    public Product getProduct() {

        Product product = null;
        Scanner sc = Properties.getSacnnerInstance();
        sc.nextLine();
        logger.info("Start taking product details from user");
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();
        product = productService.getProduct(id);
        return product;
    }

    /**
     * This method take a product details and Transactions to the database.
     * 
     * @return Returns a response message for the addition action of product
     */
    public String addProducts() {
        Scanner sc = Properties.getSacnnerInstance();
        int numberOfProducts = 0;
        String productResponse = "";
        String txnResponse = "";
        String response = "";
        String hasMoreProduct = "N";
        List<Product> productList = new ArrayList<>();
        // Calling addproduct from Product model
        AddProduct addProduct = new AddProduct();

        // Call the add transactions from transaction model
        Transaction transaction = new Transaction();
        transactionInterface.addTransaction(transaction);
        addProduct.setTransaction(transaction);
        System.out.println(txnResponse);
        // in for loop call the add product
        do {

            productResponse = addProduct(productList);
            System.out.println(productResponse + "\nDo you want to add more product(s) [Y/N]");
            numberOfProducts++;
            // flush the extra enter
            sc.nextLine();
            hasMoreProduct = sc.nextLine();

        } while (hasMoreProduct.equalsIgnoreCase("Y"));

        addProduct.setProduct(productList);
        response = productService.addProduct(addProduct);

        response = numberOfProducts + " products added successfully";

        return response;

    }

    /**
     * This method take a product details and to add the product list.
     * 
     * @return Returns a responce message for the addition action of product
     */
    public String addProduct(List<Product> productList) {
        String response = "";
        Scanner sc = Properties.getSacnnerInstance();
        sc.nextLine();
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
            product.setStatus(Properties.STATUS_AVAILABLE);

            //
            System.out.print("Enter Product ID: ");
            product.setId(sc.nextLine().toUpperCase());

            //
            System.out.print("Enter Product Category: ");
            product.setCategory(sc.nextLine().toUpperCase());

            //
            System.out.print("Enter Product Name: ");
            product.setName(sc.nextLine().toUpperCase());

            System.out.print("Enter Product Description: ");
            product.setDescription(sc.nextLine());

            System.out.print("Enter Product Cost: ");
            product.setCostPrice(sc.nextDouble());

            System.out.print("Enter Product mrp: ");
            product.setMrp(sc.nextDouble());

            // response = productService.addProduct(product);
            productList.add(product);

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            for (StackTraceElement str : e.getStackTrace()) {
                System.out.println(str.toString());
            }
            response = e.getLocalizedMessage();
        }
        return response;
    }

    /**
     * This method take a product details and call repo class to add the product.
     * 
     * @return Returns a responce message for the addition action of product
     */
    public String addProduct() {
        String response = "";
        Scanner sc = Properties.getSacnnerInstance();
        sc.nextLine();
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
            product.setStatus(Properties.STATUS_AVAILABLE);

            //
            System.out.print("Enter Product ID (e.g ABC-001): ");
            product.setId(sc.nextLine().toUpperCase());

            //
            System.out.print("Enter Product Category: ");
            product.setCategory(sc.nextLine().toUpperCase());

            //
            System.out.print("Enter Product Name: ");
            product.setName(sc.nextLine().toUpperCase());

            System.out.print("Enter Product Description: ");
            product.setDescription(sc.nextLine());

            System.out.print("Enter Product Cost: ");
            product.setCostPrice(sc.nextDouble());

            System.out.print("Enter Product mrp: ");
            product.setMrp(sc.nextDouble());

            response = productService.addProduct(product);

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            for (StackTraceElement str : e.getStackTrace()) {
                System.out.println(str.toString());
            }
            response = e.getLocalizedMessage();
        }
        return response;
    }

    public String returnTovendor() {
        String response = null;
        Scanner sc = Properties.getSacnnerInstance();
        // Adding transaction details before updateing the product status
        transactionInterface.addTransaction();
        sc.nextLine();
        logger.info("Taking product id from the user");
        System.out.print("Please enter product id: ");
        String id = sc.nextLine();
        response = productService.returnToVendor(id);

        return response;

    }



}


