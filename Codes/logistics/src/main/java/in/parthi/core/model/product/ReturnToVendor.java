package in.parthi.core.model.product;

import java.util.List;

import in.parthi.core.model.transaction.Transaction;

public class ReturnToVendor {
    private Transaction transaction;
    private List<Product> product;



    public ReturnToVendor() {
    }


    public ReturnToVendor(Transaction transaction, List<Product> product) {
        this.transaction = transaction;
        this.product = product;
    }


    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<Product> getProduct() {
        return this.product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }



}
