package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {

    @Id
    @Column(name = "CUSTOMER_ACCOUNT_ID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private  int CustomerAcId;

    @Column(name = "AC_NUMBER")
    private String AcNumber;

    @Column(name = "AC_BALANCE")
    private String AcBalance;

    public CustomerAccount() {
    }

    public CustomerAccount(String acNumber, String acBalance) {
        AcNumber = acNumber;
        AcBalance = acBalance;
    }

    public int getCustomerAcId() {
        return CustomerAcId;
    }

    public void setCustomerAcId(int customerAcId) {
        CustomerAcId = customerAcId;
    }

    public String getAcNumber() {
        return AcNumber;
    }

    public void setAcNumber(String acNumber) {
        AcNumber = acNumber;
    }

    public String getAcBalance() {
        return AcBalance;
    }

    public void setAcBalance(String acBalance) {
        AcBalance = acBalance;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "AcNumber='" + AcNumber + '\'' +
                ", AcBalance='" + AcBalance + '\'' +
                '}';
    }
}
