
/**
 * This is a Transaction class that provide the defination of the transaction and provides all the
 * method thats required to maintain the transaction.
 *
 * @author Abhishek Ray
 * @since 2025-08-30
 */

package in.parthi.core.model.transaction;

import java.time.LocalDate;
import java.util.UUID;
import in.parthi.common.PaymentMode;
import in.parthi.common.TransactionCategory;
import in.parthi.common.TransactionType;

public class Transaction {
    private String id;
    private String invoice;
    private String particular;
    private TransactionType txnType; 
    private TransactionCategory txnCategory; 
    private PaymentMode paymentMode;
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

    public Transaction(String invoice, String particular, TransactionType txnType, TransactionCategory txnCategory, PaymentMode paymentMode, String description, double amount, LocalDate transactionDate) {
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

    public TransactionType getTxnType() {
        return this.txnType;
    }

    public void setTxnType(TransactionType txnType) {
        this.txnType = txnType;
    }

    public TransactionCategory getTxnCategory() {
        return this.txnCategory;
    }

    public void setTxnCategory(TransactionCategory txnCategory) {
        this.txnCategory = txnCategory;
    }

    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
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

    public String toString(){
        return "Transaction date: " +this.getTransactionDate()+"\n"+ "Transaction Category: " +this.getTxnCategory()+"\n"+"ID: "+this.getId() + "\n" +"Invoice Id:" + this.getInvoice() +  "\n" + "Perticular: " + this.getParticular() + "\n" + "Transaction type: " + this.getTxnType()
         + "\n" + "Payment mode: " +this.getPaymentMode() + "\n" + "Amount paid: " + this.getAmount() + "\n";
    }

}
