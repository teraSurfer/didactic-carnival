/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.spring.service;
import com.tm.spring.beans.Employee;
import com.tm.spring.dao.EmpDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author MSLCELTP1800
 */
@Component
@Qualifier("eservice")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmpDAO dao;

    public void setDao(EmpDAO dao) {
        this.dao = dao;
    }
    
    @Override
    public void insert(Employee e) {
        if(dao.empInsert(e)){
            System.out.println("inserted emp--------------------------->"+e.getEmployeeName());
        }
    }

    @Override
    public void update(Employee e,int id) {
        if(dao.empUpdate(id, e)){
            System.out.println("Updated------------------------------------------>"+e);//To change body of generated methods, choose Tools | Templates.
    }
    }
    @Override
    public Employee display(int id) {
       Employee e= dao.display(id);
        return e;
    }

    @Override
    public List displayAll() {
        List l = dao.displayAll();  
        return l;
    }
    @Override
    public List displayAll(int p){
        int i = (p-1)*5;       
        List pg = dao.displayAll(i);
        return pg;
    }

    @Override
    public void delete(int id) {
       if(dao.empDelete(id)){
           System.out.println("Deleted---------------------------------------------------->"+id);
       }
    }
    @Override
    public List getPages(){
        List employees = displayAll();
        List pages = new ArrayList();
        int count=0, total = 1;
        pages.add(total);
        Iterator it = employees.iterator();
        while(it.hasNext()){
            if(count!=5){
                Employee e = (Employee)it.next();
                count++;
            }
            else{ 
                count = 0;
                total++;
                pages.add(total);                
            }
                
        }
        System.out.println(pages);
        return pages;
    }   
    }
    