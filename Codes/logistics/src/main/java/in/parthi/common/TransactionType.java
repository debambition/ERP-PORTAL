package in.parthi.common;

import java.util.Scanner;

import in.parthi.core.model.Transaction;

public enum TransactionType {
    CREDIT,DEBIT;

    public static void choose(Transaction transaction)
    {
        Scanner sc = Properties.getSacnnerInstance();
        int option;
        do{System.out.println("Enter the Transaction type \n 1)Credit \n 2)Debit\n ");
        option = sc.nextInt();
        switch(option)
        {
            case 1:
            transaction.setTxnType(CREDIT);
            break;

            case 2:
            transaction.setTxnType(DEBIT);
            break;

            default:
            System.out.println("Please enter a valid option between 1-2");


        }
        } while (option <= 0 || option >2);
        
    }
}
