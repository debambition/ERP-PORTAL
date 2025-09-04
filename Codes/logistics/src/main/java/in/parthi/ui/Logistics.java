package in.parthi.ui;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.common.Properties;
import in.parthi.core.model.Product;

public class Logistics {

    private static final Logger logger = LoggerFactory.getLogger(Logistics.class);


    public static void main(String[] args) {
        Logistics logistics = new Logistics();
        ProductInterface productInterface = new ProductInterface();
        TransactionInterface transactionInterface = new TransactionInterface();
        Scanner sc = Properties.getSacnnerInstance();
        int option = 0;
        do {
            option = logistics.getOption();

            switch (option) {
                case 1:
                    System.out.println("============Adding Product==========");
                    System.out.println(productInterface.addProduct());
                    break;
                case 2:
                    System.out.println("============Get Product==========");
                    Product product = productInterface.getProduct();
                    System.out.println(product.toString());
                    break;
                case 3:
                    System.out.println("============Return Product==========");
                    
                    System.out.println(productInterface.returnTovendor());

                    break;
                case 4:
                    System.out.println("============Adding Transaction==========");
                    System.out.println(transactionInterface.addTransaction());
                    break;
                case 5:
                    System.out.println("============Adding Customer==========");
                    break;
                case 6:
                    sc.close();
                    
                    System.out.println("Exiting Application Gracefully");
                    System.exit(0);
                default:
                    break;
            }

        } while (option >= 1 && option < 7);


    }


    /**
     * This method returns the option provided by the user
     *
     * @return Returns the choice of the user
     */
    private int getOption() {
        System.out.println("==========MENU========");
        System.out.println("1] Add product");
        System.out.println("2] Get Product");
        System.out.println("3] Return product");
        System.out.println("4] Add Transaction");
        System.out.println("5] Add Customer");
        System.out.println("6] Exit the App");
        System.out.print("Enter your option number(1 - 6): ");
        int choice = -9999;
        try {
            do {
                if (choice != -9999) {
                    System.out.print("Please select a valid choice between 1 - 6: ");
                }
                Scanner sc = Properties.getSacnnerInstance();
                choice = sc.nextInt();
            } while (choice < 1 || choice > 6);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            logger.warn(e.getMessage());
        } finally {
            // getChoice.close();
        }
        return choice;
    }
}
