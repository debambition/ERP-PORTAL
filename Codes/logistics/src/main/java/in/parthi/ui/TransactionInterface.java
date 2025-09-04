package in.parthi.ui;

import java.time.LocalDate;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.common.Properties;
import in.parthi.core.model.Transaction;
import in.parthi.core.repository.TransactionRepo;

public class TransactionInterface {
    private static final Logger logger = LoggerFactory.getLogger(TransactionInterface.class);
    TransactionRepo transactionRepo = new TransactionRepo();

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


            response = transactionRepo.addTransaction(null);
        } catch (RuntimeException e) {
            response = e.getLocalizedMessage();
            logger.error("Exception occured while adding transaction: " + e.getLocalizedMessage());
        } finally {
            sc.close();
        }
        return response;
    }
}
