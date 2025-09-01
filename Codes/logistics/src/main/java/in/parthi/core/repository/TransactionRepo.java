package in.parthi.core.repository;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.core.model.Transaction;

public class TransactionRepo {
    private static final Logger logger = LoggerFactory.getLogger(TransactionRepo.class);
    List<Transaction> transactionList = new ArrayList<>();

    /**
    * This method take a an procuct id and retrieve the product from the database.
    * 
    * @param String id with which the product needs to be found
    * @return Returns the product
    * @throws RuntimeException if the product is unavailable in the database.
    */

    public Transaction findById(String id) {
        logger.info("Finding the transaction with id: {}", id);
        return transactionList.stream().filter(transaction -> transaction.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Transaction with id: " + id + " is not available"));

    }

    public List<Transaction> findAll() {
        logger.info("Fetching all transactions");
        return transactionList;
    }
    
     public Transaction getProduct(String id) throws RuntimeException {// Create a NotFound Exception
        Transaction transaction = null;
        for (Transaction tmpProduct : transactionList) {
            if (tmpProduct.getId().equalsIgnoreCase(id)) {
                transaction = tmpProduct;
                logger.info("transaction with id: " + id + " found in database");
            }

        }

        if (transaction == null) {
            logger.warn("Transaction with id: " + id + " not found in database");
            throw new RuntimeException("The Transaction with id " + id + " Not Found");
        }

        return transaction;

    }
    
    /**
     * This method take a transaction details and add it to the database.
     * 
     * @param Transaction that need to be added to the database
     * @return Returns the choice of the user
     * @throws RuntimeException if the product is already available in the database.
     */
    public String addTransaction(Transaction transaction) throws RuntimeException {// Create a NotFound Exception
        String response = "";
        boolean hasTransaction = false;
        for (Transaction tmpTransaction : transactionList) {
            if (tmpTransaction.getId().equalsIgnoreCase(transaction.getId())) {
                hasTransaction = true;
                break;
            }

        }
        if (hasTransaction) {
            logger.warn("Transaction with id: " + transaction.getId() + " already available in database");
            throw new RuntimeException("The transaction with id " + transaction.getId()
                    + " Already present in database, Unable to create the transaction");
        } else {
            transactionList.add(transaction);
            response = "Transaction with id: " + transaction.getId() + " added successfully";
            logger.info("Transaction with id: " + transaction.getId() + " added successfully");
        }

        return response;

    }
}

