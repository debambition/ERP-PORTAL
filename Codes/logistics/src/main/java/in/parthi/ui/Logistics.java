package in.parthi.ui;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logistics {

    private static final Logger logger = LoggerFactory.getLogger(Logistics.class);
    ProductInterface productService = new ProductInterface();

    public static void main(String[] args) {
        Logistics logistics = new Logistics();
        int option = logistics.getOption();
        ProductInterface productService = new ProductInterface();

        switch (option) {
            case 1:
                System.out.println("============Adding Product==========");
                String response = productService.addProduct();
                System.out.println(response);
                break;
            case 2:
                System.out.println("============Return Product==========");
                
                break;
            case 3:
                System.out.println("============Adding Transaction==========");
                break;
            case 4:
                System.out.println("============Adding Customer==========");
                break;
            default:
                break;
        }

    }


    /**
     * This method returns the option provided by the user
     *
     * @return Returns the choice of the user
     */
    private int getOption() {
        System.out.println("==========MENU========");
        System.out.println("1] Add product");
        System.out.println("2] Return product");
        System.out.println("3] Add Transaction");
        System.out.println("4] Add Customer");

        Scanner getChoice = new Scanner(System.in);
        int choice = -9999;
        try {

            do {
                if (choice != -9999) {
                    System.out.print("Please select a valid choice between 1 - 4: ");
                }
                choice = getChoice.nextInt();
            } while (choice < 1 || choice > 4);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            logger.warn(e.getMessage());
        } finally {
            //getChoice.close();
        }

        return choice;


    }
}
