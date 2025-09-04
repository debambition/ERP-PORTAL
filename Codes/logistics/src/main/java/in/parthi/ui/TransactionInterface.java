package in.parthi.ui;

import java.time.LocalDate;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.common.PaymentMode;
import in.parthi.common.Properties;
import in.parthi.common.TransactionCategory;
import in.parthi.common.TransactionType;
import in.parthi.core.model.Transaction;
import in.parthi.core.service.TransactionService;

public class TransactionInterface {
    private static final Logger logger = LoggerFactory.getLogger(TransactionInterface.class);
    TransactionService transactionService = new TransactionService();

    /**
     * This method take a transaction details and call repo class to add the transaction.
     * 
     * @return Returns a responce message for the addition action of transaction
     */
    public String addTransaction() {
        String response = "";
        logger.info("Start taking transaction details from user");
        Scanner sc = Properties.getSacnnerInstance();
        sc.nextLine();
        int option = 0;
        Transaction transaction = new Transaction();
        try {
            // Take transaction details from user
            LocalDate today = LocalDate.now();
            System.out.print("Enter Stockin Date e.g 2025-09-23 (default: " + today.toString() + "): ");
            String strDate = sc.nextLine();
            if (strDate.length() == 0) {
                transaction.setTransactionDate(today);
            } else {
                transaction.setTransactionDate(LocalDate.parse(strDate));
            }

            //
            System.out.print("Enter Invoice Id(if any): ");
            transaction.setInvoice(sc.nextLine());

            //
            System.out.print("Enter Particular (if any): ");
            transaction.setParticular(sc.nextLine());

            //
            do {
                System.out.print("Enter Transaction Type \n 1] Credit\n2]Debit ");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        transaction.setTxnType(TransactionType.CREDIT);
                        break;
                    case 2:
                        transaction.setTxnType(TransactionType.DEBIT);
                    default:
                        System.out.println("Please enter a valid input");
                        break;
                }
            } while (option <= 0 || option > 2);

            //
            do {
                System.out.print("Enter Payment Mode\n 1] Cash\n2]Online ");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        transaction.setPaymentMode(PaymentMode.CASH);
                        break;
                    case 2:
                        transaction.setPaymentMode(PaymentMode.ONLINE);
                    default:
                        System.out.println("Please enter a valid input");
                        break;
                }
            } while (option <= 0 || option > 2);

            //
            do {
                System.out.print("Enter Payment Mode\n 1] TRAVEL\n2]FOOD ");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        transaction.setTxnCategory(TransactionCategory.TRAVEL);
                        break;
                    case 2:
                        transaction.setTxnCategory(TransactionCategory.FOOD);
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                        break;
                }
            } while (option <= 0 || option > 2);

            //flushing the extra enter
            sc.nextLine();
            //
            System.out.print("Enter Description: ");
            transaction.setDescription(sc.nextLine());

            //
            System.out.print("Enter Amount: ");
            transaction.setAmount(sc.nextDouble());

            response = transactionService.addTransaction(transaction);
        } catch (RuntimeException e) {
            response = e.getLocalizedMessage();
            logger.error("Exception occured while adding transaction: " + e.getLocalizedMessage());
        } 
        return response;
    }
}
