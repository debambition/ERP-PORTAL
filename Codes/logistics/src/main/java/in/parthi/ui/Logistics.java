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
        Scanner sc1 = new Scanner(System.in);
        int option = 0;
        do {
            option = logistics.getOption(sc1);

            switch (option) {
                case 1:
                    System.out.println("============Adding Product==========");
                    String response = productInterface.addProduct();
                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("============Get Product==========");
                    Product product = productInterface.getProduct();
                    System.out.println(product.toString());
                    break;
                case 3:
                    System.out.println("============Return Product==========");
                    break;
                case 4:
                    System.out.println("============Adding Transaction==========");
                    break;
                case 5:
                    System.out.println("============Adding Customer==========");
                    break;
                default:
                    break;
            }

        } while (option >= 1 && option < 5);

        sc1.close();

    }


    /**
     * This method returns the option provided by the user
     *
     * @return Returns the choice of the user
     */
    private int getOption(Scanner getChoice) {
        System.out.println("==========MENU========");
        System.out.println("1] Add product");
        System.out.println("2] Get Product");
        System.out.println("3] Return product");
        System.out.println("4] Add Transaction");
        System.out.println("5] Add Customer");
        System.out.println("6] Exit the App");
        System.out.print("Enter your option number(1 - 5): ");
        int choice = -9999;
        try {
            do {
                if (choice != -9999) {
                    System.out.print("Please select a valid choice between 1 - 5: ");
                }
                choice = getChoice.nextInt();
            } while (choice < 1 || choice > 5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            logger.warn(e.getMessage());
        } finally {
            // getChoice.close();
        }
        return choice;
    }
}
