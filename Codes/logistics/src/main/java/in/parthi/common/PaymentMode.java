package in.parthi.common;
import java.util.Scanner;

import in.parthi.core.model.Transaction;

public enum PaymentMode {
    CASH,
    ONLINE;


    
    // Static method for user input
    public static void choose(Transaction transaction) {
        Scanner sc = Properties.getSacnnerInstance();
        int option;
        do{System.out.print("Enter the Payment Mode \n 1)Cash \n 2)Online\n ");
        option = sc.nextInt();
        switch(option) 
        {
            case 1:
            transaction.setPaymentMode(CASH);
            break;

            case 2:
            transaction.setPaymentMode(ONLINE);
            break;

            default:
            System.out.println("Please enter a valis option between 1-2");
        }

        } while (option <=0 || option >2);
    }
}
