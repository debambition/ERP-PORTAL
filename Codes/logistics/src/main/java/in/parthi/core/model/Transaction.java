/**
 * This is a Transaction class that provide  the defination of the transaction and provides all the method
 * thats required to maintain the transaction.
 *
 * @author Abhishek Ray
 * @since 2025-08-30
 */
package in.parthi.core.model;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private String productId;
    private String customerId;
    private String transactionType; // TODO Create a enum for the status with PURCHASE, RETURN
    private String paymentMode; // TODO Create a enum for the status with CASH, CARD, UPI, NETBANKING
    String status; // TODO Create a enum for the status with PENDING, COMPLETED, FAILED
    private double amount;
    LocalDate transactionDate; 

    public Transaction() {}

    public Transaction(String id, String productId, String customerId, String transactionType, String paymentMode, double amount, LocalDate transactionDate, String status) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.transactionType = transactionType;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
    
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
