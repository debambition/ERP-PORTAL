
/**
 * This is a Transaction class that provide the defination of the transaction and provides all the
 * method thats required to maintain the transaction.
 *
 * @author Abhishek Ray
 * @since 2025-08-30
 */

package in.parthi.core.model;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private String id;
    private String invoice;
    private String particular;
    private String txnType; // TODO Create a enum for the status with CREDIT/DEBIT
    private String txnCategory; // TODO Create a enum TRAVEL,FOOD,SALARY,OPERATION COST,SALES,INSTALLMENT,PRODUCT COST,ACCESORIES,
                                // ADVERTISEMENT, CAMPAIGN COST
    private String paymentMode; // TODO Create a enum for the status with CASH, ONLINE
    private String description;
    private double amount;
    LocalDate transactionDate;

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Transaction() {
        this.id = UUID.randomUUID().toString();
    }

    public Transaction(String invoice ,String particular, String txnType, String txnCategory, String paymentMode, String description, double amount, LocalDate transactionDate) {
        this.id = UUID.randomUUID().toString();
        this.invoice = invoice;
        this.particular = particular;
        this.txnType = txnType;
        this.txnCategory = txnCategory;
        this.paymentMode = paymentMode;
        this.description = description;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnCategory() {
        return txnCategory;
    }

    public void setTxnCategory(String txnCategory) {
        this.txnCategory = txnCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

}
