/**
 * This is a customer class that provide the defination of the product and provides all the method
 * thats required to maintain the products.
 *
 * @author Moumita Chatterjee
 * @since 2025-09-01
 */




package in.parthi.core.model.customer;

import java.time.LocalDate;

public class Customer {
    
    private String id;
    private String name;
    private int phoneNumber;
    private String address;
    String status;  // TODO Create a enum for the status with PENDING, COMPLETED, FAILED
    
    LocalDate dateOfBirth;



    public Customer() {
    }


    public Customer(String id, String name, int phoneNumber, String address, String status, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    

    }





