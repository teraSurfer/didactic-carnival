/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.spring.dao;
import com.tm.spring.beans.Employee;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 *
 * @author MSLCELTP1800
 */
@Component
@Qualifier("dao")
public class EmpDAOImpl implements EmpDAO {
    @Autowired
    SessionFactory sessionFactory;    
    @Override
    public boolean empInsert(Employee emp) {
         Session session= sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(emp);
        t.commit();
        session.close();
        return true;
    }
    @Override
    public boolean empUpdate(int id,Employee emp) {
        Session session= sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Employee e=(Employee) session.load(Employee.class, id);
        session.evict(e);
        e=emp;
        session.update(e);
        t.commit();
        session.close();
        return true;
    }
    @Override
    public boolean empDelete(int id) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Employee e = (Employee)session.get(Employee.class, id);
        session.delete(e);
        t.commit();
        session.close();
        return true;
    }
    @Override
    public Employee display(int id) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Employee e = (Employee)session.get(Employee.class, id);
        t.commit();
        session.close();
        return e;
    }
    @Override
    public List displayAll() {
        List employees = new ArrayList();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria c = session.createCriteria(Employee.class);
        Iterator itr = c.list().iterator();
        while(itr.hasNext()){
            Employee e = (Employee)itr.next();
            employees.add(e);
        }
        transaction.commit();
        session.close();
        return employees;
    }
    @Override
    public List displayAll(int i) {
        List employees = new ArrayList();
        Session session = sessionFactory.openSession();
        Transaction t= session.beginTransaction();
        Criteria c = session.createCriteria(Employee.class);       
            c.setFirstResult(i);
            c.setMaxResults(5);
            employees = c.list();
        t.commit();
        session.close();
        return employees;            
    }    
}
