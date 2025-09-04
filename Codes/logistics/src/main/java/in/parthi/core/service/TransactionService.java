package in.parthi.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import in.parthi.core.model.Transaction;
import in.parthi.core.repository.TransactionRepo;

public class TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    TransactionRepo transactionRepo = new TransactionRepo();

    /**
     * This method take a Transaction details and add it to the database.
     * 
     * @param Transaction that need to be added to the database
     * @return Returns the Responce msg of the user
     */
    public String addTransaction(Transaction transaction) {
        String response = "";
        try {
            response = transactionRepo.addTransaction(transaction);
        } catch (RuntimeException e) {
            response = e.getLocalizedMessage();
            logger.error("Exception occured while adding Transaction: " + e.getLocalizedMessage());
        }
        return response;
    }
}
