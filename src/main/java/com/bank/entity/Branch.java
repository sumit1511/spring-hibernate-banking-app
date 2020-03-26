package com.bank.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BRANCH")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BRANCH_ID")
    private int branchId;
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Column(name = "BRANCH_CODE")
    private String branchCode;

    @OneToMany(mappedBy = "branch",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Customer> customers;

    public Branch() {
    }

    public Branch(String branchName, String branchCode) {
        this.branchName = branchName;
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                '}';
    }
    public void add( Customer tempCustomer)
    {
        if(customers==null)
        {
            customers= new ArrayList<Customer>();
        }
        customers.add(tempCustomer);
        tempCustomer.setBranch(this);
    }
}
