package com.bank.dao;

import com.bank.entity.Branch;
import com.bank.entity.Customer;
import com.bank.entity.CustomerAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Component
public class CustomerDao implements Serializable {

    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public  List<Customer> allCustomer()
    {Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery("SELECT * FROM customer").list();
    }
    @Transactional
    public void createCustomer(Customer customer,int branchId)
    {
        Session session = sessionFactory.getCurrentSession();
        Branch branch = session.get(Branch.class,branchId);
        String branchCode = branch.getBranchCode();
        String AcNumber=branchCode+ new Random().nextInt(10000);
        CustomerAccount customerAccount = new CustomerAccount(AcNumber,"0");
        customer.setCustomerAccount(customerAccount);
        customer.setBranch(branch);
        session.save(customer);
    }
    @Transactional
    public void deleteCustomer(int customerId)
    {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,customerId);
        session.delete(customer);
    }
    @Transactional
    public int debit(int amount,int customerId)
    {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,customerId);
        String currentBc= customer.getCustomerAccount().getAcBalance();
        int updatedBc=Integer.parseInt(currentBc)-amount;
        if(updatedBc<0)
        {
            return -1;
        }
        else {
            customer.getCustomerAccount().setAcBalance(updatedBc + "");
            session.update(customer);
        }
        return updatedBc;
    }
    @Transactional
    public int credit(int amount,int customerId)
    {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,customerId);
        String currentBc= customer.getCustomerAccount().getAcBalance();
        int updatedBc=Integer.parseInt(currentBc)+amount;
        customer.getCustomerAccount().setAcBalance(updatedBc+"");
        session.update(customer);
        return updatedBc;
    }
    @Transactional
    public Customer getCustomer(int customerId)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,customerId);
    }
}
