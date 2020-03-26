package com.bank.dao;

import com.bank.entity.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Component
public class BranchDao implements Serializable {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void createBranch( Branch branch)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(branch);
    }
    @Transactional
    public List<Branch> allBranch()
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery("SELECT * FROM branch").list();
    }
    @Transactional
    public Branch getBranch(String branchId)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Branch.class,Integer.parseInt(branchId));
    }
}
