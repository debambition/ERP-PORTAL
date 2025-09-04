package in.parthi.core.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.parthi.core.model.Invoice;
import in.parthi.core.model.Product;


public class InvoiceRepo {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceRepo.class);
    List<Invoice> invoiceList = new ArrayList<>();

       /**
     * This method take a an invoice id and retrieve the invoice from the database.
     * 
     * @param String id with which the product needs to be found
     * @return Returns the invoice
     * @throws RuntimeException if the invoice is unavailable in the database.
     */
    

      public Invoice getProduct(String id) throws RuntimeException {// Create a NotFound Exception
        Invoice invoice = null;
        for (Invoice tmpInvoice : invoiceList) {
            if (tmpInvoice .getId().equalsIgnoreCase(id)) {
                invoice = tmpInvoice ;
                logger.info("Invoice with id: " + id + " found in database");
            }

        }

        if (invoice== null) {
            logger.warn("Invoice with id: " + id + " not found in database");
            throw new RuntimeException("The product with id " + id + " Not Found");
        }

        return invoice;

    }








    public String addInvoice(Invoice invoice) throws RuntimeException {// Create a NotFound Exception
        String response = "";
        boolean hasInvoice = false;
        for (Invoice tmpProduct : invoiceList) {
            if (tmpProduct.getId().equalsIgnoreCase(invoice.getId())) {
                hasInvoice = true;
                break;
            }

        }
        if (hasInvoice) {
            logger.warn("Product with id: " + invoice.getId() + " already available in database");
            throw new RuntimeException("The product with id " + invoice.getId() + " Already present in database, Unable to create the product");
        }

        invoiceList.add(invoice);
        response = "Product added successfully";
        logger.info("Product with id: " + invoice.getId() + " added to the database");
        return response;



}
