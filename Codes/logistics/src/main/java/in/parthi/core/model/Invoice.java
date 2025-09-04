/**
 * This is invoice class that provide the defination of the invoice and provides all the method
 * thats required to maintain the invoice.
 *
 * @author Gourav Kar
 * @since 2025-08-31
 */





package in.parthi.core.model;

import java.time.LocalDate;

public class Invoice {

    private String id;
    private double amountPaid;
    LocalDate invoiceDate;
    LocalDate duteDate;
    

    public Invoice() {
    }


    public Invoice(String id, double amountPaid, LocalDate invoiceDate, LocalDate duteDate) {
        this.id = id;
        this.amountPaid = amountPaid;
        this.invoiceDate = invoiceDate;
        this.duteDate = duteDate;
    }

    



    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getInvoiceDate() {
        return this.invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getDuteDate() {
        return this.duteDate;
    }

    public void setDuteDate(LocalDate duteDate) {
        this.duteDate = duteDate;
    }

    
}
